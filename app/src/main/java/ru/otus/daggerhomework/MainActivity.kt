package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var _activityComponent: ActivityComponent? = null

    val activityComponent: ActivityComponent
        get() = _activityComponent ?: DaggerActivityComponent
            .factory()
            .create(this, (application as App).appComponent)
            .also { _activityComponent = it }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_view, FragmentReceiver())
            .add(R.id.container_view, FragmentProducer())
            .commit()
    }
}