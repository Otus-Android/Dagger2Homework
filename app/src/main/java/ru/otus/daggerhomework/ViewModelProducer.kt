package ru.otus.daggerhomework

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val mutableStateFlow: MutableStateFlow<Int>
) : ViewModel() {
    companion object {
        private const val TAG = "ViewModelProducer"
    }

    fun generateColor() {
        Log.d(TAG, "Color sent")
        mutableStateFlow.value = colorGenerator.generateColor()
    }
}