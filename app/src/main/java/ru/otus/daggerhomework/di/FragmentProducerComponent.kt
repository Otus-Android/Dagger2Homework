package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.FragmentProducer

@Component(
    modules = [ViewModelModule::class, ColorGeneratorModule::class],
    dependencies = [ApplicationComponent::class])
interface FragmentProducerComponent {

    //fun inject(fragmentProducer: FragmentProducer)

    companion object {
        fun getFragmentProducerComponent(applicationComponent: ApplicationComponent): FragmentProducerComponent {
        return DaggerFragmentProducerComponent.builder().applicationComponent(applicationComponent).build()
        }
    }
}