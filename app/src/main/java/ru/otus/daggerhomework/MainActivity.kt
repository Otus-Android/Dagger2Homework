package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory()
            .create(this, (application as App).getApplicationComponent())

        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity, ReceiverFragment())
            .add(R.id.main_activity, ProducerFragment())
            .commit()
    }

    fun getActivityComponent() = activityComponent

    companion object {
        private lateinit var activityComponent: MainActivityComponent
    }
}