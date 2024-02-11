package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.ActivityComponent
import ru.otus.daggerhomework.di.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    val activityComponent: ActivityComponent by lazy(LazyThreadSafetyMode.NONE) {
        // Попытка сохранить компонент для сохранения состояния при повроте активити.
        var component = savedActivityComponent
        if (component == null) {
            component = DaggerActivityComponent.factory().create(
                (applicationContext as App).appComponent,
                this
            )
            savedActivityComponent = component
        }
        component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        private var savedActivityComponent: ActivityComponent? = null
    }
}