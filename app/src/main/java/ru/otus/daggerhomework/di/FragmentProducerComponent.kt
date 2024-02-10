package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducer

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class]
)
interface FragmentProducerComponent {
    @Component.Factory
    interface factory {
        fun create(comp: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(f: FragmentProducer)
}

@Module
interface ColorGeneratorModule {
    @Binds
    fun provideColorGenerator(c: ColorGeneratorImpl): ColorGenerator
}
