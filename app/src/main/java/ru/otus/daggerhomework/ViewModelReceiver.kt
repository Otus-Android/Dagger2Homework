package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    private val colorObservable: IColorObservable,
) : ViewModel() {
    private val mutableState = MutableLiveData<Int>()
    val state: LiveData<Int> = mutableState

    private val colorObserver = object : IObserver<Int> {
        override fun notify(data: Int) {
            observeColors(data)
        }
    }

    init {
        colorObservable.add(colorObserver)
    }

    override fun onCleared() {
        super.onCleared()

        colorObservable.remove(colorObserver)
    }

    fun observeColors(color: Int) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received $color", Toast.LENGTH_LONG).show()

        mutableState.value = color
    }
}

class ViewModelReceiverFactory @Inject constructor(
    @ContextApplication private val context: Context,
    private val colorObservable: IColorObservable,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java))
            return ViewModelReceiver(
                context,
                colorObservable,
            ) as T
        else throw IllegalArgumentException()
    }

}