package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.App
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val mainActivityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent
            .factory()
            .create(
                (application as App).applicationComponent,
                this
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //mainActivityComponent.inject(this)    // if need some injection to MainActivity

        val fragmentProducer = FragmentProducer()
        val fragmentReceiver = FragmentReceiver()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragments, fragmentReceiver)
            .add(R.id.fragments, fragmentProducer)
            .commit()
    }
}