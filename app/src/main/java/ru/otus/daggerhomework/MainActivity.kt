package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import ru.otus.daggerhomework.di.ComponentProvider
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.getComponent
import ru.otus.daggerhomework.features.producer.FragmentProducer
import ru.otus.daggerhomework.features.receiver.FragmentReceiver

class MainActivity : AppCompatActivity(), ComponentProvider<MainActivityComponent> {

    private lateinit var _component: MainActivityComponent
    override val component: MainActivityComponent
        get() = _component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _component = DaggerMainActivityComponent.factory().create(
            context = this,
            appComponent = getComponent()
        )

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.receiver_container, FragmentReceiver.newInstance())
                replace(R.id.producer_container, FragmentProducer.newInstance())
            }
        }
    }
}