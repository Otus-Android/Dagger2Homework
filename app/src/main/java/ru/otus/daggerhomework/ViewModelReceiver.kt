package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    @Named("ApplicationContext")private val context: Context,
    private val mutableStateFlow: MutableStateFlow<Int>
) : ViewModel() {
    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int> get() = _color
    init {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
            viewModelScope.launch {
                mutableStateFlow.collect { color ->
                    Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                    _color.postValue(color) }
            }

    }
}