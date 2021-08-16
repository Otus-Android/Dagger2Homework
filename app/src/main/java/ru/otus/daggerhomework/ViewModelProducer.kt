package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val observer: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        Log.d("AppContext", context.toString())
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            observer.emit(colorGenerator.generateColor())
        }
    }
}

class ProducerViewModelFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val observer: MutableStateFlow<Int>
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ViewModelProducer(colorGenerator, context, observer) as T
}