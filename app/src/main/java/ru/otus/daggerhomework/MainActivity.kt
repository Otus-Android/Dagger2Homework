package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mainActivityComponent: MainActivityComponent? = null
    fun getMainActivityComponent() = mainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        val applicationComponent = (application as App).getAppComponent()
        mainActivityComponent = MainActivityComponent.getMainActivityComponent(applicationComponent, this)
        mainActivityComponent!!.inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()

        mainActivityComponent = null
    }
}