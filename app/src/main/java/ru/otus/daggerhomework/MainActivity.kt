package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val component by lazy {
        (application as App).component.activityComponentFactory().create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
       component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}