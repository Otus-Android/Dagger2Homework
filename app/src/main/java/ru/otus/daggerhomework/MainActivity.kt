package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var activityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory().create(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        activityComponent = null
    }

    fun activityComponent() = activityComponent!!
}