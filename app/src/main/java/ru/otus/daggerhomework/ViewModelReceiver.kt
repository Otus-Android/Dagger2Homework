package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val myViewModel: MyViewModel
) {

    private val _colorLiveData = MutableLiveData<Int>()
    var colorLiveData:LiveData<Int> = _colorLiveData

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        myViewModel.catsStateFlow.collectLatest {
            _colorLiveData.value = it
        }
    }
}