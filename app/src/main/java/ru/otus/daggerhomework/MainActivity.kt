package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.flow.Flow


fun interface ColorProducer {
    suspend fun produceColor(color: IntColor)
}

fun interface ColorReceiver {
    fun receiveColors(): Flow<IntColor>
}

class MainActivity : AppCompatActivity() {

    private lateinit var _mainComponent: MainActivityComponent
    val mainComponent get() = _mainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        _mainComponent = DaggerMainActivityComponent.factory()
            .create(appComponent, this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}