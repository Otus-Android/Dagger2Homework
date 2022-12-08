package ru.otus.daggerhomework

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private val app by lazy { application as App }
    lateinit var mainActivityComponent: MainActivityComponent
    lateinit var fragmentProducerComponent: FragmentProducerComponent
    lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent = app.appComponent.mainComponent()
            .create(this, MutableLiveData(Color.argb(0, 0, 0, 0)))
        fragmentProducerComponent = mainActivityComponent.producerComponent().create()
        fragmentReceiverComponent = mainActivityComponent.receiverComponent().create()
        setContentView(R.layout.activity_main)

    }
}