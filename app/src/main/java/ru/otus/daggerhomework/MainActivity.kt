package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.producer.FragmentProducerComponent
import ru.otus.daggerhomework.receiver.FragmentReceiver
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent:  MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        startFragment()
    }

    private fun startFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentProducer())
            .commit()

    }

    private fun init(){
        mainActivityComponent =  DaggerMainActivityComponent.factory().create(this,(application as App).appComponent)
    }
}