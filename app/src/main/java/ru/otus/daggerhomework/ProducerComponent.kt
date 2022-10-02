package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope

@ProducerScope
@Component(
    modules = [ProducerModule::class],
    dependencies = [MainActivityComponent::class],
)
interface ProducerComponent {

    companion object {
        fun getProducerComponent(mainActivityComponent: MainActivityComponent): ProducerComponent {
            return DaggerProducerComponent.factory().create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): ProducerComponent
    }

    fun inject(producerFragment: FragmentProducer)

}

@Module
interface ProducerModule {
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@Scope
annotation class ProducerScope