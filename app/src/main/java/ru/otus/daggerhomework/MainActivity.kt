package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.ActivityComponent
import ru.otus.daggerhomework.di.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    val activityComponent: ComponentHolder<ActivityComponent> by lazy(LazyThreadSafetyMode.NONE) {
        ComponentStore.get("activity") {
            DaggerActivityComponent.factory().create(
                (applicationContext as App).appComponent,
                this
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            ComponentStore.delete(activityComponent)
        }
    }
}
