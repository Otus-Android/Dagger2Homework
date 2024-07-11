package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import javax.inject.Scope

@FragmentScope
@Subcomponent
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)
}

interface FragmentProducerComponentHolder {
    fun getProducerComponent(): FragmentProducerComponent
}

@Scope
annotation class FragmentScope