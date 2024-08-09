package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver (
    private val context: Context,
    private val colorEventObserver: ColorEventObserver
) : ViewModel() {

    val color: MutableLiveData<Int> = MutableLiveData()

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            colorEventObserver.onChangeColorState {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                color.postValue(it)
            }
        }
    }

}

class ViewModelReceiverFactory @Inject constructor(
    private val context: Context,
    private val colorEventObserver: ColorEventObserver
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            return ViewModelReceiver(
                context = context,
                colorEventObserver = colorEventObserver
            ) as T
        } else throw IllegalArgumentException()
    }
}