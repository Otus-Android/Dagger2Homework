package ru.otus.daggerhomework

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


fun interface ColorProducer {
    suspend fun produceColor(@ColorInt color: Int)
}

fun interface ColorReceiver {
    fun receiveColors(): Flow<Int>
}

class MainActivity : AppCompatActivity() {

    private val colorTransactionFlow = MutableStateFlow(Color.TRANSPARENT)

    lateinit var mainComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = DaggerMainActivityComponent.factory()
            .create(
                appComponent,
                this,
                colorProducer = colorTransactionFlow::emit,
                colorReceiver = { colorTransactionFlow }
            )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}