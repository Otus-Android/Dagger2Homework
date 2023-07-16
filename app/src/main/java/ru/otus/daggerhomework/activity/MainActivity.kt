package ru.otus.daggerhomework.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.appComponent
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        val applicationComponent = appComponent
        activityComponent = DaggerMainActivityComponent
            .builder()
            .addActivityContext(this)
            .addActivityLifecycleScope(lifecycleScope)
            .addApplicationComponent(applicationComponent)
            .create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FragmentProducer())
            .add(R.id.container, FragmentReceiver())
            .commit()
    }
}