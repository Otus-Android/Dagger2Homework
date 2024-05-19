package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.GetColorRepository
import ru.otus.daggerhomework.GetColorRepositoryImpl
import ru.otus.daggerhomework.SetColorRepository
import ru.otus.daggerhomework.SetColorRepositoryImpl

@Module
interface MainActivityModule {

    @ActivityScope
    @Binds
    fun providesGetColorRepository(impl: GetColorRepositoryImpl): GetColorRepository

    @ActivityScope
    @Binds
    fun providesSetColorRepository(impl: SetColorRepositoryImpl): SetColorRepository
}
