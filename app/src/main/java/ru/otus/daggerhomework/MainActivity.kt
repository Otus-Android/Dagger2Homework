package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).applicationComponent.mainActivityComponent().create(this).inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}