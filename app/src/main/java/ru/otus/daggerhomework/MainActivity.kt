package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent =
            (application as App).appComponent.mainActivityComponent().create(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}