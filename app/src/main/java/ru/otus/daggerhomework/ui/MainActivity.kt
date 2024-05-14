package ru.otus.daggerhomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.components.MainActivityComponent

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        val applicationComponent = (application as App).applicationComponent
        mainActivityComponent =
            DaggerMainActivityComponent.factory().create(applicationComponent, this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}