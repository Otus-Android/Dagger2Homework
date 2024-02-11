package ru.otus.daggerhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val stateObserver: StateObserver,
) : ViewModel() {

    private val _colorLiveData = MutableLiveData<Int>()
    val colorLiveData: LiveData<Int> = _colorLiveData

    fun generateColor() {
        viewModelScope.launch {
            stateObserver.setState(colorGenerator.generateColor())
            _colorLiveData.value = _colorLiveData.value?.plus(1)
        }
    }
}

class ViewModelProviderFactory
@Inject
constructor(
    private val colorGenerator: ColorGenerator,
    private val stateObserver: StateObserver,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ViewModelProducer::class.java -> {
                ViewModelProducer(colorGenerator, stateObserver)
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }
}
