package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ProducerModule::class]
)
interface FragmentProducerComponent {

    companion object {

        fun init(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.factory()
                .create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}

@Module
interface ProducerModule {

    @Binds
    fun bindColorGenerator(generator: ColorGeneratorImpl): ColorGenerator
}