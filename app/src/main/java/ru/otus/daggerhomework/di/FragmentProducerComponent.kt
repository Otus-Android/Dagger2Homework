package ru.otus.daggerhomework.di

import android.app.Activity
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.Observer
import ru.otus.daggerhomework.ViewModelProducer

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface FragmentProducerComponentFactory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}

@Module
class FragmentProducerModule {
    @FragmentScope
    @Provides
    fun provideViewModel(
        colorGenerator: ColorGenerator,
        activity: Activity,
        observer: Observer
    ): ViewModelProducer {
        return ViewModelProducer(colorGenerator, activity, observer)
    }
}