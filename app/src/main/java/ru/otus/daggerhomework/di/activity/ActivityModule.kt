package ru.otus.daggerhomework.di.activity

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.presentation.viewmodels.ActivityViewModel
import ru.otus.daggerhomework.presentation.viewmodels.ReceiveColorFlow
import ru.otus.daggerhomework.presentation.viewmodels.SentColor

@Module
object ActivityModule {

    @Provides
    fun provideSentColor(observer: ActivityViewModel): SentColor = observer

    @Provides
    fun provideReceiveColor(observer: ActivityViewModel): ReceiveColorFlow = observer

    @ActivityScope
    @Provides
    fun provideViewModelObserver() = ActivityViewModel()
}