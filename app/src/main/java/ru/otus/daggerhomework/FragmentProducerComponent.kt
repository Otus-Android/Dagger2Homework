package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.qualifiers.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}

@Module
interface FragmentProducerModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}
