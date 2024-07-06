package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var activityComponent: MainActivityComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = (application as App).getApplicationComponent()
            .addMainActivityComponent()
            .create(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentReceiver, FragmentReceiver())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentProducer, FragmentProducer())
            .commit()
    }

    fun getActivityComponent() = activityComponent
}