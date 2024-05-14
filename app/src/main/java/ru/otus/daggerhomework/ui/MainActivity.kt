package ru.otus.daggerhomework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.components.MainActivityComponent
import ru.otus.daggerhomework.ui.producer.FragmentProducer
import ru.otus.daggerhomework.ui.receiver.FragmentReceiver

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        val applicationComponent = (application as App).applicationComponent
        mainActivityComponent =
            DaggerMainActivityComponent.factory().create(applicationComponent, this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FragmentReceiver())
            .add(R.id.fragment_container, FragmentProducer())
            .commit()
    }
}