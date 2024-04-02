package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.components.FragmentProducerComponent
import ru.otus.daggerhomework.di.components.FragmentReceiverComponent
import ru.otus.daggerhomework.di.components.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = this.applicationContext
        mainActivityComponent =
            DaggerMainActivityComponent.factory().create(this, (appContext as App).getAppComponent())
        mainActivityComponent.inject(this)
        setContentView(R.layout.activity_main)
    }

}