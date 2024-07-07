package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponentHolder

class MainActivity : AppCompatActivity(), MainActivityComponentHolder {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            this,
            (application as App).appComponent
        )

        supportFragmentManager.beginTransaction().add(
            R.id.container1,
            FragmentProducer(),
            ""
        ).commit()
    }

    override fun getActivityComponent(): MainActivityComponent {
        return mainActivityComponent
    }
}