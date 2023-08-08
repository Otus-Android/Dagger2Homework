package ru.otus.daggerhomework.di.producer

import dagger.Component
import dagger.Subcomponent
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope
import ru.otus.daggerhomework.presentation.producer.FragmentProducer

/**
 * `Dagger` [Component] `Fragment`-а поставления цветов
 */
@FragmentScope
@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    /** Внедрить зависимости [FragmentProducer]-а */
    fun inject(producer: FragmentProducer)

    /** Фабрика `Dagger` [Component]-а Fragment`-а поставления цветов */
    @Subcomponent.Factory
    interface Factory {

        /** Создать [FragmentProducerComponent] */
        fun create(): FragmentProducerComponent
    }
}