package ru.otus.daggerhomework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import javax.inject.Inject

@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    @Inject
    protected lateinit var fragmentProducer: FragmentProducer

    @Inject
    protected lateinit var fragmentReceiver: FragmentReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appComponent = (applicationContext as App).appComponent
        val activityComponent = DaggerMainActivityComponent.factory()
            .create(applicationComponent = appComponent, context = this).inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.producerFragmentLayout, fragmentProducer)
                .commitAllowingStateLoss()

            supportFragmentManager.beginTransaction()
                .replace(R.id.receiverFragmentLayout, fragmentReceiver)
                .commitAllowingStateLoss()

        }
    }
}