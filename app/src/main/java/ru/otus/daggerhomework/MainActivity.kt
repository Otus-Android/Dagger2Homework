package ru.otus.daggerhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ru.otus.daggerhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityComponent: MainActivityComponent
    lateinit var producerFragmentComponent: ProducerFragmentComponent
    lateinit var receiverFragmentComponent: ReceiverFragmentComponent

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = DaggerMainActivityComponent.factory().create(this)
        producerFragmentComponent = mainActivityComponent.createProducerFragmentSubComponent()
        receiverFragmentComponent = mainActivityComponent.createReceiverFragmentSubComponent()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ProducerFragment>(binding.producer.id)
                add<ReceiverFragment>(binding.receiver.id)
            }

        }
    }
}