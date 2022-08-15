package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = (application as App).appComponent.mainActivityComponent().create(this)
        activityComponent.inject(this)

        initFragments()
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_a_container, FragmentProducer()).commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_b_container, FragmentReceiver()).commit()
    }
}