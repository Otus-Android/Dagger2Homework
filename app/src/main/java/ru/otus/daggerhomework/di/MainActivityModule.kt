package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ChannelColorObserver
import ru.otus.daggerhomework.ColorObserver

@Module
interface MainActivityModule {

    @MainActivityScope
    @Binds
    fun bindColorObserver(colorObserver: ChannelColorObserver): ColorObserver
}