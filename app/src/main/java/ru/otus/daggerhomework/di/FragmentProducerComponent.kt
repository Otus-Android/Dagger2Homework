package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
    fun provideColorGenerator(): ColorGenerator
    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerModule {
    @FragmentScope
    @Binds
    fun colorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}