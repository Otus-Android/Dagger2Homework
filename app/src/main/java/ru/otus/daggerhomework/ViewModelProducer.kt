package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityScope
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentScope
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    val colorGenerator: ColorGenerator,
    @ActivityContext val context: Context,
    val mutableStateFlow: MutableStateFlow<Int>
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        mutableStateFlow.value = color
    }
}