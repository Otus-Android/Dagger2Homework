package ru.otus.daggerhomework.di.module

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl

@Module
interface ColorObserverModule {

    @Binds
    fun bindColorObserver(colorObserverImpl: ColorObserverImpl): ColorObserver
}