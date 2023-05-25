package ru.otus.daggerhomework

import android.os.*
import androidx.appcompat.app.*
import javax.inject.*

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.factory()
            .create(this, (application as App).appComponent).inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentProducer, FragmentProducer())
            .add(R.id.fragmentReceiver, FragmentReceiver())
            .commit()
    }
}