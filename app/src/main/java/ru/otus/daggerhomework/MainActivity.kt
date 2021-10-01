package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.component.MainActivityComponent
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent =
            (application as App).appComponent.mainActivityComponentBuild().activityContext(this)
                .build()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_producer, FragmentProducer())
            .add(R.id.fragment_receiver, FragmentReceiver())
            .commit()
    }
}