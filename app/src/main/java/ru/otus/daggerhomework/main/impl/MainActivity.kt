package ru.otus.daggerhomework.main.impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.main.impl.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainActivityComponent.create(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        MainActivityComponent.release()
    }
}