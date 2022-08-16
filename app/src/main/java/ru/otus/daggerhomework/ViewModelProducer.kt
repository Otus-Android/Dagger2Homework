package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorState: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorState.value = colorGenerator.generateColor()
    }

    class Factory @Inject constructor(
        private val colorGenerator: Provider<ColorGenerator>,
        @ActivityName private val context: Provider<Context>,
        private val colorState: Provider<MutableStateFlow<Int>>,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
                ViewModelProducer(
                    colorGenerator.get(),
                    context.get(),
                    colorState.get()
                ) as T
            } else {
                throw IllegalStateException("Unknown ViewModel class")
            }
        }
    }
}