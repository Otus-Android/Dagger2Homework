package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.IDataKeeper
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.FragmentScope

@FragmentScope
@Component(dependencies = [ActivityComponent::class])
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideDataKeeper(): IDataKeeper
}