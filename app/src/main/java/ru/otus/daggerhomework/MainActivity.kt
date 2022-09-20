package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).appComponent)
            .also { activityComponent = it }

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_view, FragmentReceiver())
            .add(R.id.container_view, FragmentProducer())
            .commit()
    }
}