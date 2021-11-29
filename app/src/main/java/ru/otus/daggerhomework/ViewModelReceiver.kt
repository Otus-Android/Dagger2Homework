package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.AppContext
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Singleton

class ViewModelReceiver(
    private val context: Context,
    private val transceiver: Transceiver
) : ViewModel() {

    val color: LiveData<Int> by lazy { _color }
    private val _color: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            while (true) {
                _color.value = transceiver.receive()
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }
        }
    }
}

class ViewModelReceiverFactory @Inject constructor(
    @AppContext private val context: Context,
    private val transceiver: Transceiver
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelReceiver(context, transceiver) as T
    }
}