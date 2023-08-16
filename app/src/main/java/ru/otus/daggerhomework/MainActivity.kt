package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationComponent = (application as App).getAppComponent()
        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, applicationComponent)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentProducer())
            .add(R.id.container, FragmentReceiver())
            .commit()
    }
}