package ru.otus.daggerhomework.viewModels

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.components.ApplicationContext
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: FragmentActivity
) : ViewModel() {

    @Inject
    lateinit var stateFlow: StateFlow<Int>

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}