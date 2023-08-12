package ru.otus.daggerhomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.R

class MainActivity : AppCompatActivity() {
    private lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = MainActivityComponent.getMainActivityComponent(this)
        setContentView(R.layout.activity_main)
    }

    fun getActivityComponent() : MainActivityComponent =
        activityComponent
}