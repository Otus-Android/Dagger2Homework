package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.component.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.component.MainActivityComponent

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent =
            DaggerMainActivityComponent.factory().build((application as App).appComponent, this)


        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_receiver, ReceiverFragment())
            .add(R.id.fragment_producer, ProducerFragment())
            .commit()

    }
}