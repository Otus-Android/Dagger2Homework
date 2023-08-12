package ru.otus.daggerhomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.feature.di.ActivityComponentHolder
import ru.otus.daggerhomework.feature.fragments.ProducerFragment
import ru.otus.daggerhomework.feature.fragments.ReceiverFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeComponent()
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addFragments()
        }
    }

    private fun initializeComponent() {
        getActivityComponent().inject(this)
    }

    private fun addFragments() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_producer, ProducerFragment())
            replace(R.id.fragment_receiver, ReceiverFragment())
            addToBackStack(null)
        }.commit()
    }

    fun getActivityComponent(): MainActivityComponent =
        ActivityComponentHolder.getActivityComponent(this, application as App)

    override fun onDestroy() {
        super.onDestroy()
        if (!isChangingConfigurations) {
            ActivityComponentHolder.clear()
        }
    }
}