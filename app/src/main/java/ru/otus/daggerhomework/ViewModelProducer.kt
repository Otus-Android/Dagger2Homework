package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer (
    private val colorGenerator: ColorGenerator,
    @Named("MainActivityContext")
    private val context: Context,
    private val produser: MutableStateFlow<Int>
) : ViewModel() {

    fun provideColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color создан + $context + $produser", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            val color = colorGenerator.generateColor()
            produser.value=color
        }
    }

    class FactoryProducer @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @Named("MainActivityContext")
        private val context: Context,
        private val produser: MutableStateFlow<Int>
    ):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            Log.d("TAG", "create")
            return ViewModelProducer(colorGenerator,context,produser) as T
        }
    }
}