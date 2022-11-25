package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.qualifiers.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val stateFLow: MutableStateFlow<Int>,
    @ActivityContext private val context: Context
) {

    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val newColorInt = colorGenerator.generateColor()
        stateFLow.emit(newColorInt)
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}