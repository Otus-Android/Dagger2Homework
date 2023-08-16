package ru.otus.daggerhomework.producer

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.di.MainActivityComponent

@FragmentScope
@Component (modules = [FragmentProducerModule::class],
    dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    fun provideViewModelProducer(): ViewModelProducer

    companion object {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent
                .builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
        }
    }
}

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}
