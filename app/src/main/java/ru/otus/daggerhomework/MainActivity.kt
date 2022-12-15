package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = DaggerMainActivityComponent
            .factory()
            .create((application as App).applicationComponent, this)

        val fragmentReceiver = FragmentReceiver()
        val fragmentProducer = FragmentProducer()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragmentReceiver)
            .add(R.id.container, fragmentProducer)
            .commit()
    }
}
