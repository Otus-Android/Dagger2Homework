package ru.otus.daggerhomework

import dagger.Component

@FragmentColorScope
@Component(
    modules = [ColorGeneratorModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    companion object{
        fun getFragmentProducerComponent(mainActivityComponent: MainActivityComponent): FragmentProducerComponent{
            return DaggerFragmentProducerComponent.builder().mainActivityComponent(mainActivityComponent).build()
        }
    }

    fun inject(fragmentProducer: FragmentProducer)

}

