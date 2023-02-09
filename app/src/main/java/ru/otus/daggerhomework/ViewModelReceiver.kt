package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val colorRepository: ColorRepository
) {

    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int> = _color

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        colorRepository.getColorFlow().collect {
            _color.value = it
        }
    }
}