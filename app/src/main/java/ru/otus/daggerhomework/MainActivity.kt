package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.fragments.producer.FragmentProducer
import ru.otus.daggerhomework.fragments.recevier.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityComponent = (application as App)
            .applicationComponent
            .mainActivityComponent()
            .create(this)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrameA, FragmentProducer())
            .replace(R.id.containerFrameB, FragmentReceiver())
            .commitAllowingStateLoss()
    }
}
