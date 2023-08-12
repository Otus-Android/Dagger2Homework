package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module


@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
@FragmentScope
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

}

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}