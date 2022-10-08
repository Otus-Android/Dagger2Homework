package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.components.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var activityComponent: MainActivityComponent? = null
    @Inject
    @ApplicationContext
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory()
            .add(this, (application as App).getApplicationComponent())
        activityComponent?.inject(this)
    }

    fun getActivityComponent(): MainActivityComponent? {
        return activityComponent
    }

    override fun onDestroy() {
        super.onDestroy()
        activityComponent = null
    }
}