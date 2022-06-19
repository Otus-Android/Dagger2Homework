package ru.otus.daggerhomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.activity.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.activity.di.MainActivityComponent
import ru.otus.daggerhomework.application.App
import ru.otus.daggerhomework.application.di.DaggerApplicationComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, (application as App).applicationComponent)
    }
}