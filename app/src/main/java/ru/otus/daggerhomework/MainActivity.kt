package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.appComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(this, appComponent)

    }

}