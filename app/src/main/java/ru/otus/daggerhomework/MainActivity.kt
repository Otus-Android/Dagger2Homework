package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = (application as App).appComponent.mainActivityComponent().create(this)

        val fragmentProducer = FragmentProducer()
        val fragmentReceiver = FragmentReceiver()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, fragmentProducer)
                add(R.id.fragment_container_view, fragmentReceiver)
                commit()
            }
        }
    }
}