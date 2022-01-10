package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ColorObserver
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named
@ExperimentalCoroutinesApi
@FlowPreview
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val observer: ColorObserver,
    @Named("activity")
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            observer.state.value = colorGenerator.generateColor()
        }
    }
}