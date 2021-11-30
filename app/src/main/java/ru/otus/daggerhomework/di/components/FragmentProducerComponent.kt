package ru.otus.daggerhomework.di.components

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.di.dependencies.FragmentProducerDependencies
import ru.otus.daggerhomework.presentation.producer.FragmentProducer
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl
import ru.otus.daggerhomework.utils.FragmentScope

@FragmentScope
@Component(
    dependencies = [FragmentProducerDependencies::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

}

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

}



