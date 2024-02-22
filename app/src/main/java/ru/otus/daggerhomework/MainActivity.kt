package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.ActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = (application as App).appComponent.activityComponent.create(this)

        setContentView(R.layout.activity_main)
    }
}