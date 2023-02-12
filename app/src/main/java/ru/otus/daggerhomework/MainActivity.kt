package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).appComponent)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_producer_id, FragmentProducer())
            .add(R.id.fragment_receiver_id, FragmentReceiver())
            .commit()
    }
}