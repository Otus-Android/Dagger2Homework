package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.components.MainActivityComponent

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(App.applicationComponent, this)

        supportFragmentManager.beginTransaction()
            .add(R.id.first_container, FragmentProducer())
            .add(R.id.second_container, FragmentReceiver())
            .commit()
    }
}