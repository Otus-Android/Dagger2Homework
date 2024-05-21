package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory()
            .create(appComponent = (application as App).getAppComponent(), context = this)
        activityComponent.inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentProducerContainer, FragmentProducer())
                .add(R.id.fragmentReceiverContainer, FragmentReceiver())
                .commit()
        }
    }

    fun getActivityComponent(): MainActivityComponent = activityComponent
}