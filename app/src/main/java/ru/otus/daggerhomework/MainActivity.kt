package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            activityContext = this,
            applicationComponent = (application as App).applicationComponent
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transactionToFragmentProducer()
        transactionToFragmentReceiver()
    }

    private fun transactionToFragmentProducer() {
        supportFragmentManager.beginTransaction()
            .add(R.id.producerFragmentContainer, FragmentProducer())
            .commit()
    }

    private fun transactionToFragmentReceiver() {
        supportFragmentManager.beginTransaction()
            .add(R.id.receiverFragmentContainer, FragmentReceiver())
            .commit()
    }
}