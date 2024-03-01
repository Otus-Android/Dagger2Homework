package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component = DaggerMainActivityComponent
            .factory()
            .create(
                this,
                (application as App).applicationComponent,
            )

        setContentView(R.layout.activity_main)
    }
}