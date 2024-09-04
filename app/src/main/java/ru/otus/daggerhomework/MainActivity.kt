package ru.otus.daggerhomework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {
lateinit var mainActivityComponent: MainActivityComponent
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      mainActivityComponent =  DaggerMainActivityComponent.factory().create(this, (application as App).getAppComponent())
         mainActivityComponent.inject(this)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, FragmentReceiver())
            .add(android.R.id.content, FragmentProducer()).commit()

    }
}