package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.otus.daggerhomework.Activity
import ru.otus.daggerhomework.Application
import ru.otus.daggerhomework.ColorGenerator
import java.lang.RuntimeException
import java.lang.ref.WeakReference
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @Activity private val context: WeakReference<Context>,
    private val flow: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context.get() !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            flow.emit(colorGenerator.generateColor())
        }
        Toast.makeText(context.get(), "Color sent", Toast.LENGTH_LONG).show()
    }
}