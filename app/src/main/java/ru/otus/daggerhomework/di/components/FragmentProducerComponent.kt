package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.IDataKeeper
import ru.otus.daggerhomework.di.FragmentScope

@FragmentScope
@Component(dependencies = [ActivityComponent::class])
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)

    fun provideDataKeeper(): IDataKeeper

    fun provideColorGenerator(): ColorGenerator
}