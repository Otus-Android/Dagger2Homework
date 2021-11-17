package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.components.MainActivityComponent
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent
        mainActivityComponent = DaggerMainActivityComponent.builder().activityContext(this).applicationComponent(appComponent).build()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.producer_fragment, FragmentProducer())
        transaction.add(R.id.receiver_fragment, FragmentReceiver())
        transaction.commit()

    }
}