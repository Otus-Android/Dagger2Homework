package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentComponent {

    @Component.Factory
    interface ProducerComponentFactory{
        fun create(mainActivityComponent: MainActivityComponent):FragmentComponent
    }

    fun injectFragmentProducer(fragment: FragmentProducer)
    fun injectFragmentReceiver(fragment: FragmentReceiver)
}

