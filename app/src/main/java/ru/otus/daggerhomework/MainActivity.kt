package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.factory()
            .create(this, (application as App).appComponent).inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentProducer, FragmentProducer())
            .add(R.id.fragmentReceiver, FragmentReceiver())
            .commit()
    }
}