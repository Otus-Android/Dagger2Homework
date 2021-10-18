package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.component.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.component.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent

        mainActivityComponent = DaggerMainActivityComponent.builder().activityContext(this)
            .applicationComponent(appComponent).build()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_producer, FragmentProducer())
            .add(R.id.fragment_receiver, FragmentReceiver())
            .commit()
    }
}