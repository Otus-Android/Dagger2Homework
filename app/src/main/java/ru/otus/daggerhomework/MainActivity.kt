package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.App.Companion.appComponentMain
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {
     lateinit var appComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = DaggerMainActivityComponent.factory().create(this, appComponentMain)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}