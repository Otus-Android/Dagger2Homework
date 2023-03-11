package ru.otus.daggerhomework

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityComponent = MainActivityComponent.getMainActivityComponent(this)

        setContentView(R.layout.activity_main)
    }
}

fun Activity.requireMainActivityComponent() = (this as MainActivity).mainActivityComponent