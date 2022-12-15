package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject
import javax.inject.Named

@ActivityScope
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @Named("activityContext") val context: Context,
    private val colorStateFlow: MutableStateFlow<Int>,
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                colorStateFlow.value = colorGenerator.generateColor()
            }
        }
    }
}
