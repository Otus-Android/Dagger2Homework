package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.FragmentProducer
import javax.inject.Scope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)

    fun provideColorObserver(): ColorObserver

    fun provideColorGenerator(): ColorGenerator
}

@Scope
annotation class FragmentScope