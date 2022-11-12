package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject

private const val TAG = "MainActivityTag"

class MainActivity : AppCompatActivity() {
    private lateinit var _mainActivityComponent: MainActivityComponent
    val mainActivityComponent: MainActivityComponent get() = _mainActivityComponent

    init {
        Log.d(TAG, "init block")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        _mainActivityComponent = (application as App).applicationComponent.mainActivityComponent().create(this)

        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}