package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = DaggerMainActivityComponent.factory().create(this, application.asApp().appCompoment)
        supportFragmentManager.beginTransaction().add(R.id.container, FragmentReceiver()).commit()
        supportFragmentManager.beginTransaction().add(R.id.container, FragmentProducer()).commit()
    }
}