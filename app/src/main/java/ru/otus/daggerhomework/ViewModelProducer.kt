package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val mutableStateFlow: MutableStateFlow<Int>,
    @ActivityContext private val context: Context
) {

    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        delay(500)
        mutableStateFlow.value = colorGenerator.generateColor()
    }
}