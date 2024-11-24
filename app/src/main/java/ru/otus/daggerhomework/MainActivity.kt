package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.activity.DaggerActivityComponent
import ru.otus.daggerhomework.di.producer.FragmentProducer

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.factory()
            .create(this, applicationComponent = (application as App).applicationComponent)

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentProducer())
            .commit()
    }
}