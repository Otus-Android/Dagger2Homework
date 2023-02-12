package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.PerFragment
import ru.otus.daggerhomework.di.module.ColorGeneratorModule

@Component(
    modules = [ColorGeneratorModule::class],
    dependencies = [MainActivityComponent::class]
)
@PerFragment
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    companion object {
        fun crateComponent(
            activityComponent: MainActivityComponent
        ): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()
        }
    }
}