package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Named


class ViewModelProducer (
    private val colorGenerator: ColorGenerator,
    @Named("MainActivityContext") private val context: Context,
    private val mutableStateFlow: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
       viewModelScope.launch {
           mutableStateFlow.value = colorGenerator.generateColor()

       }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}