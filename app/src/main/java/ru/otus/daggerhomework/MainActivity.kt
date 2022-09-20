package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var activityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerMainActivityComponent.factory().create(this, (application as App).getAppComponent())
        setContentView(R.layout.activity_main)
    }

    fun activityComponent() = activityComponent!!
}