package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

@SuppressLint("StaticFieldLeak")
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @Named("activity") private val context: Context,
    private val state: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        state.value = colorGenerator.generateColor()
    }
}
