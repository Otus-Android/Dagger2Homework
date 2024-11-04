package ru.otus.daggerhomework.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.fragments.FragmentProducer
import ru.otus.daggerhomework.fragments.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(
                this, (application as App).appComponent
            )

        supportFragmentManager.commit {
            add(R.id.frame_layout, FragmentReceiver())
            add(R.id.frame_layout, FragmentProducer())
        }
    }
}