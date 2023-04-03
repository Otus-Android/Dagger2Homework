package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val mainActivityComponent: MainActivityComponent by lazy {
        MainActivityComponent.init((application as App).getApplicationComponent(), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent.inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.producer_fragment_container_view, FragmentProducer())
            .add(R.id.receiver_fragment_container_view, FragmentReceiver())
            .commit()
    }

    fun getActivityComponent() = mainActivityComponent
}