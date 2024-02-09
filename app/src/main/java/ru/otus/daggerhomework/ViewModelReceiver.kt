package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext
    private val context: Context,

    private val myObserver: MyObserver
) {
    private val _colorLiveData = MutableLiveData<Int>()
    val colorLiveData = _colorLiveData

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        myObserver.observe().collect {
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            _colorLiveData.value = it
        }
    }
}