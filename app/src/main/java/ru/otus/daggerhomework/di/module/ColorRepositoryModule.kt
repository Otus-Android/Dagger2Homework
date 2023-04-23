package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.di.PerActivity
import ru.otus.daggerhomework.repository.ColorRepository
import ru.otus.daggerhomework.repository.ColorRepositoryImpl

@Module
class ColorRepositoryModule {

    @Provides
    @PerActivity
    fun provideColorRepository() : ColorRepository {
        return ColorRepositoryImpl()
    }
}