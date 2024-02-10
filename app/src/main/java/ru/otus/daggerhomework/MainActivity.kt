package ru.otus.daggerhomework

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component = DaggerMainActivityComponent.factory()
            .create(this, (application as App).component)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.producer, FragmentProducer.newInstance())
                add(R.id.receiver, FragmentReceiver.newInstance())
            }
        }
    }
}