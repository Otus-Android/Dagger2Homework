package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationComponent = (application as App).applicationComponent
        activityComponent = DaggerMainActivityComponent.factory()
            .create(this, applicationComponent)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main, FragmentReceiver())
                .add(R.id.main, FragmentProducer())
                .commit()
        }
    }

    fun getActivity() = activityComponent

    companion object {
        private lateinit var activityComponent: MainActivityComponent
    }
}