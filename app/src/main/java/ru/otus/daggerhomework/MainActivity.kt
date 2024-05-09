package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var component: MainActivityComponent

    fun getMainComponent() = component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component = MainActivityComponent.create(
            context = this,
            applicationComponent = (application as App).getAppComponent()
        )
    }
}