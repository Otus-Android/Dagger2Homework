package ru.otus.daggerhomework.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.app.di.ApplicationComponent
import ru.otus.daggerhomework.main.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityComponent.init(
            applicationContext = ApplicationComponent.getInstance().applicationContext,
            activityContext = this
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        MainActivityComponent.release()
    }
}