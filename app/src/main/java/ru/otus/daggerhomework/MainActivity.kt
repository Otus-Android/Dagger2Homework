package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import ru.otus.daggerhomework.R.id
import ru.otus.daggerhomework.R.layout
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        component = DaggerMainActivityComponent.factory().create(this, (application as App).appComponent)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(id.receiver_container, FragmentReceiver())
                replace(id.producer_container, FragmentProducer())
            }
        }
    }
}