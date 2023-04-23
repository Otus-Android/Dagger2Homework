package ru.otus.daggerhomework.usecases

import ru.otus.daggerhomework.repository.ColorRepository
import javax.inject.Inject

class SetColorsUseCaseImpl@Inject constructor(private val colorRepository: ColorRepository): SetColorsUseCase {

    override operator fun invoke(color: Int) =  colorRepository.updateColor(color)
}