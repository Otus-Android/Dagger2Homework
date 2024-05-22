package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import ru.otus.daggerhomework.di.component.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.component.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).getAppComponent()

        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            activityContext = this,
            applicationComponent = appComponent
        )

        mainActivityComponent.inject(this)

        supportFragmentManager.commit {
            add(R.id.fragment_container_a, FragmentProducer())
            add(R.id.fragment_container_b, FragmentReceiver())
        }
    }

    fun getMainActivityComponent(): MainActivityComponent {
        return mainActivityComponent
    }
}