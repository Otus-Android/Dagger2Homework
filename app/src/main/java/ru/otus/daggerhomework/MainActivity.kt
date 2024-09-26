package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityComponent = (application as App).appComponent
            .getMainActivityComponent().create(applicationContext)
        mainActivityComponent.inject(this)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.content_receiver, FragmentReceiver())
            .add(R.id.content_producer, FragmentProducer())
            .commit()
    }
}