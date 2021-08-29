package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@SuppressLint("StaticFieldLeak")
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val channel: MutableSharedFlow<Int>,
    @Named("activityContext") private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            channel.emit(colorGenerator.generateColor())
        }
    }
}