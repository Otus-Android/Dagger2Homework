package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityQualifier
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityQualifier private val context: Context,
    private val colorStateFlow: MutableStateFlow<Int>
) {

    private val scope =
        CoroutineScope(Dispatchers.Main + CoroutineName("ViewModelProducer") + SupervisorJob())

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val currentColor = colorGenerator.generateColor()
        scope.launch {
            colorStateFlow.emit(currentColor)
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}