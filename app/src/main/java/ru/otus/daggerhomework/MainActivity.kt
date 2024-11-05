package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = MainActivityComponent.getMainActivityComponent(
            this,
            (application as App).appComponent
        )
    }

    val activityComponent: MainActivityComponent get() = mainActivityComponent

}