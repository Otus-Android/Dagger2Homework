package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@Named("ReceiverFactory")
class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val colorEventObserver: ColorEventObserver
) {

    private val _color: MutableLiveData<Int> = MutableLiveData()
    val color: LiveData<Int> = _color

    private val scope = CoroutineScope(context = Dispatchers.Default)

    fun observeColors(): LiveData<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return _color
    }

}