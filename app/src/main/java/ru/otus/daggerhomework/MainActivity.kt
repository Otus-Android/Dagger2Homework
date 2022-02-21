package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var mainActivityComponent: MainActivityComponent
    }
    private val stateFlow = MutableStateFlow(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = DaggerMainActivityComponent.factory().create(WeakReference(this), stateFlow)
    }
}