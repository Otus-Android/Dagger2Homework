package ru.otus.daggerhomework.di.fragment

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.scopes.FragmentScope

@FragmentScope
@Subcomponent
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}