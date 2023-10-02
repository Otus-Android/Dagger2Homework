package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModelProducer @Inject constructor(
    @ActivityContext private val context: Context,
    private val flow: MutableStateFlow<Int?>,
    private val colorGenerator: ColorGenerator,
) {
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        scope.launch {
            flow.value = colorGenerator.generateColor()
        }

        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }

    fun onClear() {
        scope.cancel()
    }
}