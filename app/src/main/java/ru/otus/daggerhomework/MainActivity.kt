package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import ru.otus.daggerhomework.di.DaggerApplicationComponent
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    var mainActivityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.builder()
            .appComponent(appComponent)
            .context(this)
            .build()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.container_producer, FragmentProducer())
            add(R.id.container_receiver, FragmentReceiver())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainActivityComponent = null
    }
}