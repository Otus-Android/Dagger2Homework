package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: IColorGenerator,
    @ActivityContext
    private val context: Context,
    private val flow: MutableStateFlow<Int?>
) {

    private val scope = CoroutineScope(Dispatchers.Main + Job())

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        scope.launch {
            flow.value = colorGenerator.generateColor()
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }

    fun onCleared() {
        scope.cancel()
    }
}