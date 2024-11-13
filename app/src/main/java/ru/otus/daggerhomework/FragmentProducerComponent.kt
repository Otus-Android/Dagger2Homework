package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FragmentProducerComponent {

    companion object {
        fun getFragmentProducerComponent(applicationComponent: ApplicationComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .applicationComponent(applicationComponent).build()
        }
    }
}
