package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    var mainActivityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory()
            .create((application as App).appComponent, this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, FragmentProducer())
            .commit()
    }

    fun navigateToReceiverFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, FragmentReceiver())
            .addToBackStack(null)
            .commit()
    }
}
