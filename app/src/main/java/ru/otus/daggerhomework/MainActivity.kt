package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        mainActivityComponent =
            DaggerMainActivityComponent
                .factory()
                .create((application as App).applicationComponent, this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}