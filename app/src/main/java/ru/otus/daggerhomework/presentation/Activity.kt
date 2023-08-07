package ru.otus.daggerhomework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.main.MainActivityComponent

/**
 * Главный экран
 */
class Activity : AppCompatActivity(), ActivityProvider {

    override lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = MainActivityComponent.create(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}