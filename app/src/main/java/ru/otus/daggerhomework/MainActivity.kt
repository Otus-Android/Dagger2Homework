package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent = (application as App).getAppComponent()
            .addMainActivitySubComponent()
            .create(this)

        setContentView(R.layout.activity_main)
    }

    fun getMainActivityComponent() = mainActivityComponent
}