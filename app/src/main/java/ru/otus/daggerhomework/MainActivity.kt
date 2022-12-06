package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val applicationComponent = (application as App).applicationComponent
        mainActivityComponent = DaggerMainActivityComponent
            .factory().create(applicationComponent = applicationComponent, context = this)

        val fragmentReceiver = FragmentReceiver()
        val fragmentProducer = FragmentProducer()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, fragmentReceiver)
            .add(R.id.main_container, fragmentProducer)
            .commit()
    }
}