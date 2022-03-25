package ru.otus.daggerhomework.di.modules.appModule

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.components.AppScope

@Module
interface AppModule {

    @Binds
    @AppScope
    fun bindColorGeneratorImpl(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}