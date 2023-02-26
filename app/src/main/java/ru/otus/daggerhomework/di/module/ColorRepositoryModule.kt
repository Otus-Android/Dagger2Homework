package ru.otus.daggerhomework.di.module

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.repository.ColorRepository
import ru.otus.daggerhomework.repository.ColorRepositoryImpl

@Module
interface ColorRepositoryModule {

    @Binds
    fun getRepository(repository: ColorRepositoryImpl) : ColorRepository
}