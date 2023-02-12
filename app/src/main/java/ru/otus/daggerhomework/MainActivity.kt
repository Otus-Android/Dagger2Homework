package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import ru.otus.daggerhomework.di.components.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = MainActivityComponent.createComponent(
            context = this,
            appComponent = (application as App).getAppComponent()
        )

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_producer_container, FragmentProducer::class.java, bundleOf())
                .add(R.id.fragment_receiver_container, FragmentReceiver::class.java, bundleOf())
                .commit()
        }
    }
}