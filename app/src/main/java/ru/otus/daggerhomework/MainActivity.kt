package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.components.FragmentProducerComponent
import ru.otus.daggerhomework.di.components.FragmentReceiverComponent
import ru.otus.daggerhomework.di.components.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent
    lateinit var fragmentProducerComponent: FragmentProducerComponent
    lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = this.applicationContext
        mainActivityComponent =
            DaggerMainActivityComponent.factory().create(this, (appContext as App).getAppComponent())
        mainActivityComponent.inject(this)
        fragmentProducerComponent = mainActivityComponent.fragmentProducerComponentBuilder().applicationContext(appContext).build()
        fragmentReceiverComponent = mainActivityComponent.fragmentReceiverComponentBuilder().applicationContext(appContext).build()
        setContentView(R.layout.activity_main)
    }

}