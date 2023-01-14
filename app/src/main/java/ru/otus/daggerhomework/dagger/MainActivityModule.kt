package ru.otus.daggerhomework.dagger

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl

@Module
interface MainActivityModule {

    @MainActivityScope
    @Binds
    fun bindColorObserver(colorObserver: ColorObserverImpl): ColorObserver
}
