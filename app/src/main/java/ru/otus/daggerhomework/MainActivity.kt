package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val applicationComponent = (application as App).applicationComponent
        mainActivityComponent = DaggerMainActivityComponent.factory().create(applicationComponent,this)
        mainActivityComponent.inject(this)

        val fragmentProducer = FragmentProducer()
        val fragmentReceiver = FragmentReceiver()

        println(mainActivityComponent.activityContext())

        supportFragmentManager.beginTransaction()
            .add(R.id.fragments,fragmentReceiver)
            .add(R.id.fragments,fragmentProducer)
            .commit()
    }
}