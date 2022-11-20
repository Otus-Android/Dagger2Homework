package ru.otus.daggerhomework.producer

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.ActivityContext
import ru.otus.daggerhomework.MainActivityComponent

@Component(
    modules = [ProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @ActivityContext
    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: MainActivityComponent
        ): FragmentProducerComponent
    }
}