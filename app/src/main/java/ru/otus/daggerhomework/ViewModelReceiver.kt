package ru.otus.daggerhomework

import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class ViewModelReceiver @Inject constructor(
    private val colorsController: ColorsController,
) {
    val colors: StateFlow<Int>
        get() = colorsController.colors
}