package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
object ColorGeneratorModule {
    @Provides
    fun colorGenerator(): ColorGenerator = ColorGeneratorImpl()
}