package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                this,
                (application as App).getAppComponent()
            )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentProducer, FragmentProducer())
            .add(R.id.fragmentReceiver, FragmentReceiver())
            .commit()
    }

    fun getActivityComponent() = activityComponent

}