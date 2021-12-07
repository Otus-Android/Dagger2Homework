package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val appComponent by lazy { (application as App).appComponent }
    val activityComponent by lazy {
        DaggerMainActivityComponent.factory().create(this, appComponent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.producer_fragment_container, FragmentProducer())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.receiver_fragment_container, FragmentReceiver())
            .commit()
    }
}