package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.MainActivityComponent
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

     lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = (application as App).applicationComponent.mainActivityComponentFactory().create(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}