package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
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

    @Binds
    fun bindViewModelFactory(viewModelProducerFactory: ViewModelProducerProviderFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideViewModelProducer(factory: ViewModelProvider.Factory) = factory.create(ViewModelProducer::class.java)
    }
}

@Scope
annotation class ProducerScope