package ru.otus.daggerhomework.di.fragments

import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.activity.ActivityComponent

@FragmentScope
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [ActivityComponent::class]
)
interface FragmentProducerComponent {

    fun provideColorGenerator(): ColorGenerator

    fun inject(fragment: FragmentProducer)

    @Component.Factory
    interface FragmentProducerComponentFactory {
        fun create(activityComponent: ActivityComponent): FragmentProducerComponent
    }

    companion object {

        private var fragmentProducerComponent: FragmentProducerComponent? = null

        fun getFragComponent(activityComponent: ActivityComponent): FragmentProducerComponent {
            return fragmentProducerComponent ?: DaggerFragmentProducerComponent
                .factory().create(activityComponent).also {
                    fragmentProducerComponent = it
                }
        }
    }
}