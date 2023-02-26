package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.component.MainActivityComponent
import ru.otus.daggerhomework.fragments.FragmentProducer
import ru.otus.daggerhomework.fragments.FragmentReceiver

class MainActivity : AppCompatActivity() {

    private lateinit var component: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component = MainActivityComponent.create(
            context = this,
            appComponent = (application as App).appComponent
        )

        supportFragmentManager.beginTransaction()
            .add(R.id.producer_frg, FragmentProducer())
            .add(R.id.receiver_frg, FragmentReceiver())
            .commit()
    }

    fun getComponent() = component
}