package ru.otus.daggerhomework.di.component

import dagger.Subcomponent
import ru.otus.daggerhomework.di.module.ColorModule
import ru.otus.daggerhomework.di.scope.FragmentScope
import ru.otus.daggerhomework.producer.FragmentProducer

@FragmentScope
@Subcomponent(modules = [ColorModule::class])
interface FragmentProducerComponent {

    fun injectFragmentProducer(fragment: FragmentProducer)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentProducerComponent
    }
}