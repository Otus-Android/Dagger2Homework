package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val flow: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor(context: Context) {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        flow.value = colorGenerator.generateColor()
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val flow: MutableStateFlow<Int>
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelProducer(colorGenerator, flow) as T

}