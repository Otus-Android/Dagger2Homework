package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = DaggerMainActivityComponent.factory()
            .create(
                context = this,
                applicationComponent = (application as App).applicationComponent
            )

        supportFragmentManager.commit {
            add(R.id.fragment_container_a, FragmentProducer())
            add(R.id.fragment_container_b, FragmentReceiver())
        }
    }
}
