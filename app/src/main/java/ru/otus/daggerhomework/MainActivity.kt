package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.components.MainActivityComponent


class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create((application as App).appComponent, this)
    }
}