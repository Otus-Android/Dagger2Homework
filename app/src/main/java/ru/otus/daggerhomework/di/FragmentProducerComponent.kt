package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.presentation.producer.ViewModelProducer
import ru.otus.daggerhomework.util.ColorGenerator

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    val viewModelFactory: ViewModelProducer.Factory
    val colorGenerator: ColorGenerator
    @get:ActivityContext val activityContext: Context

    @Component.Factory
    interface Factory {

        fun create(
            component: MainActivityComponent
        ): FragmentProducerComponent
    }

    companion object {

        fun factory(): FragmentProducerComponent.Factory = DaggerFragmentProducerComponent.factory()
    }
}
