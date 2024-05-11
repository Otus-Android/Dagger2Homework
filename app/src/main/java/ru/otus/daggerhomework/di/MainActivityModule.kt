package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorStorageRepository
import ru.otus.daggerhomework.ColorStorageRepositoryImpl

@Module
interface MainActivityModule {

    @ActivityScope
    @Binds
    fun providesRepository(impl: ColorStorageRepositoryImpl): ColorStorageRepository
}
