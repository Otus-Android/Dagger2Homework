package ru.otus.daggerhomework
import dagger.Binds
import dagger.Component
import dagger.Module

@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    val viewModelProducer: ViewModelProducer
}
@Module
interface FragmentProducerModule {
    @Binds
    fun colorGenerator(generator: ColorGeneratorImpl): ColorGenerator
}