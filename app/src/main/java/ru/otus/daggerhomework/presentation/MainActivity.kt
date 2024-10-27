package ru.otus.daggerhomework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.main.MainActivityComponent

class MainActivity : AppCompatActivity(), ActivityProvider {

    override lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = App.appComponent(this).mainActivityComponentFactory.create(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}