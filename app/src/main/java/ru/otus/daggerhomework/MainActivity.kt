package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.dagger.DaggerMainActivityComponent
import ru.otus.daggerhomework.dagger.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = DaggerMainActivityComponent.factory().create(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
