package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val applicationComponent = (application as App).applicationComponent
        mainActivityComponent = DaggerMainActivityComponent.factory().create(applicationComponent,this)
        mainActivityComponent.inject(this)

        val fragmentProducer = FragmentProducer()
        val fragmentReceiver = FragmentReceiver()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragments,fragmentProducer)
            .add(R.id.fragments,fragmentReceiver)
            .commit()
    }
}