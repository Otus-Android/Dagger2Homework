package ru.otus.daggerhomework.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : FragmentActivity() {

    val mainActivityComponent by lazy {
        MainActivityComponent.getMainActivityComponent(
            (application as App).getApplicationComponent(),
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}