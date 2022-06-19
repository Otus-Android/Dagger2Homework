package ru.otus.daggerhomework.producer

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.activity.di.ActivityContext
import ru.otus.daggerhomework.application.di.ApplicationContext
import ru.otus.daggerhomework.receiver.ViewModelReceiver
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorState: MutableStateFlow<Int?>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            colorState.value = colorGenerator.generateColor()
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }

    class Factory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @ActivityContext private val context: Context,
        private val colorState: MutableStateFlow<Int?>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ViewModelProducer(colorGenerator, context, colorState) as T
        }
    }
}