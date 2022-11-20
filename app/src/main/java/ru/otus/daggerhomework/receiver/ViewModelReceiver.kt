package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val receiverFlow: MutableStateFlow<Int?>
) : ViewModel() {

    private val _receiver = MutableLiveData<Int>()
    val receiver: LiveData<Int> = _receiver

    init {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            receiverFlow.collect {
                it?.let {
                    _receiver.postValue(it)
                }
            }
        }
    }
}