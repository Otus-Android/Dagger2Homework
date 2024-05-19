package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.activityMain.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.activityMain.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory()
            .create((application as App).getAppComponent(), this)

        mainActivityComponent.inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentProducerContainer, FragmentProducer())
                .add(R.id.fragmentReceiverContainer, FragmentReceiver())
                .commit()
        }
    }

    fun getMainActivityComponent(): MainActivityComponent {
        return mainActivityComponent
    }
}