package ru.otus.daggerhomework

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.component.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.component.MainActivityComponent

class MainActivity : AppCompatActivity() {
    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component =
            DaggerMainActivityComponent.factory().build(application.appComponent)


        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_receiver, ReceiverFragment())
            .add(R.id.fragment_producer, ProducerFragment())
            .commit()

    }
}

val Activity.component: MainActivityComponent get() = (this as MainActivity).component