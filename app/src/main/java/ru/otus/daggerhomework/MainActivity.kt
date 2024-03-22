package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var mainActivityComponent: MainActivityComponent? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).applicationComponent)
    }
}