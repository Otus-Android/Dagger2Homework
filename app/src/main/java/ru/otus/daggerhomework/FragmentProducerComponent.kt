package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {
    companion object {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent =
            DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
    }

    fun inject(fragmentProducer: FragmentProducer)
}

@Module
interface FragmentProducerModule {
    @Binds
    fun provideViewModel(viewModelProducerFactory: ViewModelProducerFactory): ViewModelProvider.Factory

    @Binds
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}