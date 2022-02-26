package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.base.addFragment
import ru.otus.daggerhomework.di.main.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.main.MainActivityComponent
import ru.otus.daggerhomework.producer.FragmentProducer

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment()
        initDagger()
    }

    private fun addFragment() {
        supportFragmentManager
            .addFragment(R.id.main_container, FragmentProducer.newInstance())
    }

    private fun initDagger() {
        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).appComponent, MutableStateFlow(0))
    }
}