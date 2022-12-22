package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import ru.otus.daggerhomework.di.components.ActivityComponent
import ru.otus.daggerhomework.di.components.DaggerActivityComponent
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as App).appComponent
        activityComponent = DaggerActivityComponent
            .factory()
            .create(
                appComponent,
                this
            )

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, FragmentReceiver())
            .add(R.id.fragmentContainer, FragmentProducer())
            .commit()
    }
}

