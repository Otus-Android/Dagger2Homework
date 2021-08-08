package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponentProvider

class MainActivity : AppCompatActivity(), MainActivityComponentProvider {

    private var mainActivityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.receiverFragment, FragmentReceiver())
            .add(R.id.producerFragment, FragmentProducer())
            .commit()
    }

    override fun getMainActivityComponent() = mainActivityComponent ?: MainActivityComponent.create(this).also {
        mainActivityComponent = it
    }
}
