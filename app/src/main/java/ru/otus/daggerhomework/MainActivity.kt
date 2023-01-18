package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.*

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        mainActivityComponent = DaggerMainActivityComponent.factory().create(MainActivityModule(this))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}