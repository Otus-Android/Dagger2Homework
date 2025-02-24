package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.MainActivityComponent


class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityComponent = (applicationContext as App).appComponent
            .addMainActivityComponent()
            .create(this)

        mainActivityComponent.inject(this)

        setContentView(R.layout.activity_main)
    }
}