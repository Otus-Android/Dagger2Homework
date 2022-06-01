package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.qualifiers.AppContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @AppContext
    @Inject
    lateinit var appContext: Context

    val activityComponent: ActivityComponent by lazy {
        createActivityComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun injectDependencies() {
        activityComponent.inject(this)
    }

    private fun createActivityComponent(): ActivityComponent = (application as App)
        .componentInstance
        .provideActivityComponentFactory()
        .create(context = this)
}