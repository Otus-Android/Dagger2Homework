package ru.otus.daggerhomework.producers

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ActivityContext
import ru.otus.daggerhomework.ColorGenerator
import javax.inject.Inject

class ViewModelProducer  @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext val context: Context,
    private val source: MutableStateFlow<Int>
) {
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        coroutineScope.launch { source.emit(colorGenerator.generateColor()) }
    }

    fun clear() {
        coroutineScope.cancel()
    }
}