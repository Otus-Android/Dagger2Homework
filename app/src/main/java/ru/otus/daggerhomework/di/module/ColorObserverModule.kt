package ru.otus.daggerhomework.di.module

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl
import ru.otus.daggerhomework.di.PerActivity

@Module
interface ColorObserverModule {

    @Binds
    @PerActivity
    fun bindColorObserver(colorObserverImpl: ColorObserverImpl): ColorObserver
}