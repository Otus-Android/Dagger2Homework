package ru.otus.daggerhomework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.applicationComponent

class MainActivity : AppCompatActivity() {

    val component by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerMainActivityComponent
            .factory()
            .create(this, applicationComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

