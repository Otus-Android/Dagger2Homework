package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.coroutines.flow.MutableStateFlow


class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = DaggerMainActivityComponent.factory()
            .crete(this, (this.applicationContext as App).appComponent)
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.container_fragment, FragmentProducer()).commit()
        val transaction2: FragmentTransaction = manager.beginTransaction()
        transaction2.add(R.id.container_fragment2, FragmentReceiver()).commit()
    }
}