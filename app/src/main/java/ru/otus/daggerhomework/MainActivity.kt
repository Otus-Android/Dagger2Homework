package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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