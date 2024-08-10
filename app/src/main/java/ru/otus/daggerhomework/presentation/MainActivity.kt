package ru.otus.daggerhomework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent =
            (application as App).appComponent.mainActivityComponent().create(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}