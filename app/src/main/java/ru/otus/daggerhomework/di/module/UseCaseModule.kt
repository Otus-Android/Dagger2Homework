package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.repository.ColorRepository
import ru.otus.daggerhomework.usecases.ProvideColorsUseCase
import ru.otus.daggerhomework.usecases.ProvideColorsUseCaseImpl
import ru.otus.daggerhomework.usecases.SetColorsUseCase
import ru.otus.daggerhomework.usecases.SetColorsUseCaseImpl

@Module
class UseCaseModule {

    @Provides
    fun provideColorUseCase(repository: ColorRepository): ProvideColorsUseCase {
        return ProvideColorsUseCaseImpl(repository)
    }

    @Provides
    fun provideSetColorUseCase(repository: ColorRepository): SetColorsUseCase {
        return SetColorsUseCaseImpl(repository)
    }
}