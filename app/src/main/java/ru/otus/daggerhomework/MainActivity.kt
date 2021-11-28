package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver


class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

         (application as App).appComponent.activityComponent().create(this).also{
             activityComponent = it
         }.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, FragmentReceiver())
            .add(R.id.fragment_holder, FragmentProducer())
            .commit()
    }

}