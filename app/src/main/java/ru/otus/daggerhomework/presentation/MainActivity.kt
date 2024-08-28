package ru.otus.daggerhomework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                context = this,
                applicationComponent = (application as App).applicationComponent
            )
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container_a, FragmentProducer.newInstance())
                add(R.id.fragment_container_b, FragmentReceiver.newInstance())
            }
        }
    }
}