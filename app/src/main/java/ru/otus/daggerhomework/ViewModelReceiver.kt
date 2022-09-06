package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Application,
    private val source: MutableStateFlow<Int>
): ViewModel(){


    fun observeColors(populateColor: (color: Int) -> Unit) {
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            source.collect {
                populateColor(it)
            }
        }
    }
}