package ru.otus.daggerhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var _activityComponent: MainActivityComponent

    val activityComponent: MainActivityComponent
        get() = _activityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                activityContext = this,
                applicationComponent = (application as App).appComponent
            )

        setContentView(R.layout.activity_main)
    }
}