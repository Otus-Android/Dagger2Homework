package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.producer.FragmentProducer

class MainActivity : AppCompatActivity() {

    val activityComponent by lazy {
        DaggerMainActivityComponent.factory().create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        setFragment(FragmentProducer.newInstance())
    }
}