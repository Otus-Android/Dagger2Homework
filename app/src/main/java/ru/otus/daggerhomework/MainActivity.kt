package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var _mainActivityComponent: MainActivityComponent
    val mainActivityComponent: MainActivityComponent get() = _mainActivityComponent

    @Inject
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivityComponent = (application as App).applicationComponent.mainActivityComponent()
            .create()
        mainActivityComponent.inject(this)

        setContentView(R.layout.activity_main)
    }
}