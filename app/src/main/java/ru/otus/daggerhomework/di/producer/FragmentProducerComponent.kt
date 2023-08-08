package ru.otus.daggerhomework.di.producer

import dagger.Component
import ru.otus.daggerhomework.di.main.MainActivityComponent
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope
import ru.otus.daggerhomework.presentation.producer.FragmentProducer

/**
 * `Dagger` [Component] `Fragment`-а поставления цветов
 */
@FragmentScope
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    /** Внедрить зависимости [FragmentProducer]-а */
    fun inject(producer: FragmentProducer)

    companion object {

        /** Создать `Dagger` [Component] `Fragment`-а поставления цветов на основе [MainActivityComponent] */
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent =
            DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
    }
}