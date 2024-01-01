package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.activity.ActivityComponentHolder
import ru.otus.daggerhomework.di.app.appComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_producer_container, FragmentProducer())
//            .replace(R.id.fragment_receiver_container, FragmentReceiver())
//            .commit()

        ActivityComponentHolder
            .getActivityComponent(application.appComponent, this)
            .inject(this)
    }
}