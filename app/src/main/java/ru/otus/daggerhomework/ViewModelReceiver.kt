package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ActivityContext private val context: Context,
    val color: LiveData<Int>
) {
init {
    color.observe((context as MainActivity)){
        observeColors()
    }
}

    private fun observeColors() {
        if (context !is MainActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}