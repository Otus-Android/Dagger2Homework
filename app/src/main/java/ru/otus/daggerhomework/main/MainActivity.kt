package ru.otus.daggerhomework.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R

class MainActivity : AppCompatActivity() {

    val activityComponent by lazy {
        DaggerMainActivityComponent.factory()
            .create(this, (applicationContext as App).applicationComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
    }
}