package ru.otus.daggerhomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.applicationComponent

class MainActivity : AppCompatActivity() {

    private val component by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerMainActivityComponent
            .factory()
            .create(this, applicationComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = component.provideFragmentFactory()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

