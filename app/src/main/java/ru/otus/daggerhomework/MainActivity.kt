package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var _activityComponent: MainActivityComponent? = null

    val activityComponent: MainActivityComponent
        get() = _activityComponent ?: DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).appComponent)
            .also { _activityComponent = it }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_activity, FragmentReceiver())
            .add(R.id.main_activity, FragmentProducer())
            .commit()
    }
}