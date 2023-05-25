package ru.otus.daggerhomework

import android.content.*
import android.widget.*
import androidx.fragment.app.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

class ViewModelProducer @Inject constructor(
    private val colorGenerator: IColorGenerator,
    @ActivityContext
    private val context: Context,
    private val flow: MutableStateFlow<Int?>
) {

    private val scope = CoroutineScope(Dispatchers.Main + Job())

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст")

        scope.launch {
            flow.value = colorGenerator.generateColor()
        }
    }

    fun onCleared() {
        scope.cancel()
    }
}