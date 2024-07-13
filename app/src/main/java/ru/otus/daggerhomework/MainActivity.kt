package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var activityComponent : MainActivityComponent
        private set

    override fun onCreate(savedInstanceState : Bundle?) {
        activityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                activityContext = this,
                appComponent = (application as App).appComponent
            )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentProducer())
                .commit()
        }
    }
}
