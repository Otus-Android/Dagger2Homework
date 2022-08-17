package ru.otus.daggerhomework.screens.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import ru.otus.daggerhomework.screens.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.screens.producer.FragmentProducer
import ru.otus.daggerhomework.screens.receiver.FragmentReceiver
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @ApplicationContext
    lateinit var context: Context

    private var activityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureActivityComponent()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentProducer>(R.id.producer_container_view)
            add<FragmentReceiver>(R.id.receiver_container_view)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activityComponent = null
    }

    fun getActivityComponent() = activityComponent ?: throw IllegalStateException("Activity component is null!")

    private fun configureActivityComponent() {
        val applicationComponent = (application as App).getComponentInstance()
        DaggerMainActivityComponent.factory()
            .create(applicationComponent, this)
            .also { component ->
                activityComponent = component
                component.inject(this)
            }
    }
}