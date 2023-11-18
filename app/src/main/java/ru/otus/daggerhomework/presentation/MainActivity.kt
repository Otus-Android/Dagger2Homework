package ru.otus.daggerhomework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = DaggerActivityComponent.factory().create(
            context = this,
            appComponent = (this.application as App).component
        )

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view_a, FragmentProducer())
            .add(R.id.fragment_container_view_b, FragmentReceiver())
            .commit()
    }
}