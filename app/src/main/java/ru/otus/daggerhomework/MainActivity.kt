package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    var activityComponent: MainActivityComponent by Delegates.notNull()
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerMainActivityComponent.factory().create(this)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_a, FragmentReceiver())
            replace(R.id.fragment_b, FragmentProducer())
            addToBackStack(null)
        }.commit()
    }
}