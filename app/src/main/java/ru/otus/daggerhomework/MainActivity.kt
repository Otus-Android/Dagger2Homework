package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainActivityComponent.factory()
            .create(
                activityContext = this,
                applicationComponent = (application as App).applicationComponent
            )
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
