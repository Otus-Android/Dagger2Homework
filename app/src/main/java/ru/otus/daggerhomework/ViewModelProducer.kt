package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class ViewModelProducer @Inject constructor(
    private val colorsController: ColorsController,
    private val colorGenerator: ColorGenerator,
): ViewModel() {
    fun generateColor() {
        colorsController.updateColor(colorGenerator.generateColor())
    }
}