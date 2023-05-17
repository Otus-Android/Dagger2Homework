package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            applicationComponent = (application as App).getApplicationComponent(),
            activityContext = this
        )
        mainActivityComponent.inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentProducer, FragmentProducer())
            .add(R.id.fragmentReceiver, FragmentReceiver())
            .commit()
    }
}
