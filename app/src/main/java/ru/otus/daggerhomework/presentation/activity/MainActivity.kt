package ru.otus.daggerhomework.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.app.App
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent = MainActivityComponent.factory().create(
            (application as App).appComponent,
            this
        )
        setContentView(R.layout.activity_main)
    }
}
