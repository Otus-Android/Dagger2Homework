package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.Lazy
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Provider

class ViewModelProducer @AssistedInject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val appEventFlow: Lazy<MutableSharedFlow<AppEvent>>,
    @Assisted savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _colorRgbaLiveData = savedStateHandle.getLiveData<Int?>(KEY_COLOR, null)
    val colorRgbaLiveData: LiveData<Int?> = _colorRgbaLiveData

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        val color = colorGenerator.generateColor()
        _colorRgbaLiveData.value = color
        appEventFlow.get().tryEmit(AppEvent.ChangeColor(color))
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ViewModelProducer
    }

    companion object {
        private const val KEY_COLOR = "COLOR"
    }
}