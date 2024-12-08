package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.MainActivityComponent


class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = MainActivityComponent.getInstance(
            (applicationContext as App).appComponent,
            this
        )

        if (savedInstanceState == null) {
            val producerFragment: Fragment = FragmentProducer()
            supportFragmentManager.beginTransaction()
                .replace(R.id.producer, producerFragment)
                .commit()

            val receiverFragment: Fragment = FragmentReceiver()
            supportFragmentManager.beginTransaction()
                .replace(R.id.receiver, receiverFragment)
                .commit()
        }
    }
}