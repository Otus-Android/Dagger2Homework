package ru.otus.daggerhomework.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.applicaion.App

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = DaggerActivityComponent.factory().create(
            this, (application as App).appComponent
        )
    }
}