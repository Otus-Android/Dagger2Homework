package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity()  {

    val component: MainActivityComponent
        get() = _component
    private lateinit var _component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _component = DaggerMainActivityComponent.factory().create(
            this,
            (application as App).component,
        )

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.receiver_container, FragmentReceiver.newInstance())
                replace(R.id.producer_container, FragmentProducer.newInstance())
            }
        }
    }
}
