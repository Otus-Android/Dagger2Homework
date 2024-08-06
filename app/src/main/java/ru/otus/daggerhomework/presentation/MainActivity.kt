package ru.otus.daggerhomework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.applicationComponent
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                context = this,
                applicationComponent = applicationComponent
            )
        setContentView(R.layout.activity_main)
    }
}