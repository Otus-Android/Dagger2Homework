package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val colorStateFlow: StateFlow<Int>,
) {

    private val coroutineScope: CoroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        coroutineScope.launch {
            (colorStateFlow as MutableStateFlow).value = colorGenerator.generateColor()
        }
    }
}
