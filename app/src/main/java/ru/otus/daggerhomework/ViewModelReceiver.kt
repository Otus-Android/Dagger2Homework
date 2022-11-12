package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ViewModelReceiver @AssistedInject constructor(
    @ApplicationContext private val context: Context,
    private val appEventFlow: MutableSharedFlow<AppEvent>,
    @Assisted savedStateHandle: SavedStateHandle
): ViewModel() {
    companion object {
        private const val TAG = "ViewModelReceiverTag"

        private const val KEY_COLOR = "COLOR_RECEIVER" // один и тот же цвет сохранится 2 раза
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ViewModelReceiver
    }

    private val _colorRgbaLiveData = savedStateHandle.getLiveData<Int?>(KEY_COLOR, null)
    val colorRgbaLiveData: LiveData<Int?> get() = _colorRgbaLiveData

    init {
        Log.d(TAG, "init block")
        viewModelScope.launch {
            appEventFlow.filter { it is AppEvent.ChangeColor }.collect() {
                _colorRgbaLiveData.value = (it as AppEvent.ChangeColor).colorRgba
                observeColors()
            }
        }
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }
}