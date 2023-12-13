package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface MainActivityModule {
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

    @ActivityScope
    @Binds
    fun bindColorObserver(impl: ColorObserverImpl): ColorObserver
}
