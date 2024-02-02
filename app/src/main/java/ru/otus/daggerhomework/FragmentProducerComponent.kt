package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Component(dependencies = [ApplicationComponent::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    companion object{
        fun getFragmentProducerComponent(applicationComponent: ApplicationComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder().applicationComponent(applicationComponent).build()
        }
    }
}