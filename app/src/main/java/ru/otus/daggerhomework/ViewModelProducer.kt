package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.Constants.ACTIVITY_CONTEXT
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val flow: MutableStateFlow<Int?>,
    @Named(ACTIVITY_CONTEXT)
    private val context: Context
) {

    private val producerScope = CoroutineScope(Dispatchers.Main + Job())
    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        producerScope.launch {
            val color = async { colorGenerator.generateColor() }
            flow.value = color.await().also {
                Toast.makeText(context, String.format("Color sent %s", it), Toast.LENGTH_LONG).show()
            }
        }


    }
}
