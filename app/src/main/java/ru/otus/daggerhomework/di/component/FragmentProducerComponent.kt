package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.di.PerFragment
import ru.otus.daggerhomework.di.module.ColorGeneratorModule
import ru.otus.daggerhomework.fragments.FragmentProducer

@Component(
    modules = [ColorGeneratorModule::class],
    dependencies = [MainActivityComponent::class]
)
@PerFragment
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    companion object {
        fun create(
            activityComponent: MainActivityComponent
        ): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()
        }
    }
}