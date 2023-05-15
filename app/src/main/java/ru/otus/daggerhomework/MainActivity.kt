package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = (application as App).applicationComponent
            .mainActivityComponent()
            .create(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}