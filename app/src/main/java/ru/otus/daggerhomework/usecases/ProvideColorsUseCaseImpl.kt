package ru.otus.daggerhomework.usecases

import ru.otus.daggerhomework.repository.ColorRepository
import javax.inject.Inject

class ProvideColorsUseCaseImpl @Inject constructor(private val colorRepository: ColorRepository) : ProvideColorsUseCase {

    override operator fun invoke() = colorRepository.getColorFlow()
}