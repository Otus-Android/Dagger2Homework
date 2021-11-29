package ru.otus.daggerhomework.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App.Companion.getAppComponent
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.presentation.producer.FragmentProducer

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainComponent = DaggerMainActivityComponent
            .factory()
            .create(this, getAppComponent())


        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_layout, FragmentProducer(), FragmentProducer.TAG)
            .addToBackStack(null)
            .commit()
    }
}