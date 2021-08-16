package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val mutableSharedFlow: MutableSharedFlow<Int>
) : ViewModel() {

    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        mutableSharedFlow.emit(colorGenerator.generateColor())
    }

    class ProducerViewModelFactory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        private val context: Context,
        private val mutableSharedFlow: MutableSharedFlow<Int>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModelProducer::class.java))
                return ViewModelProducer(colorGenerator, context, mutableSharedFlow) as T
            else
                throw IllegalArgumentException()
        }
    }
}