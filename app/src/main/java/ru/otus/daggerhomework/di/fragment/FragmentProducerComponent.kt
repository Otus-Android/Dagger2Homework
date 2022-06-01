package ru.otus.daggerhomework.di.fragment

import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [FragmentProducerComponentModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        
        fun create(): FragmentProducerComponent
    }
}

@Module
class FragmentProducerComponentModule