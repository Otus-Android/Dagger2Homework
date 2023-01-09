package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.ActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = (application as App).applicationComponent
            .activityComponentFactory()
            .create(this)

        val fragmentReceiver = FragmentReceiver()
        val fragmentProducer = FragmentProducer()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragmentReceiver)
            .add(R.id.container, fragmentProducer)
            .commit()
    }
}
