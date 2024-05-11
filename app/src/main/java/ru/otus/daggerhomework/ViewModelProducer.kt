package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorStorageRepository: ColorStorageRepository,
    @ActivityContext private val context: Context
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        colorStorageRepository.setColor(color)

        Toast.makeText(context, "Color $color sent", Toast.LENGTH_LONG).show()
    }
}