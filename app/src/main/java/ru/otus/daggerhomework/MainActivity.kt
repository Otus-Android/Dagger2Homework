package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).appComponent)
        mainActivityComponent.inject(this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, FragmentReceiver(), FragmentReceiver::class.java.canonicalName)
            .add(R.id.fragment_container_view, FragmentProducer(), FragmentProducer::class.java.canonicalName)
            .commit()
    }
}