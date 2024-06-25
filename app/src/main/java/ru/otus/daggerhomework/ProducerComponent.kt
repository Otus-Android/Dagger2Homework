package ru.otus.daggerhomework

import dagger.Component
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ProducerModule::class]
)
interface ProducerComponent {

    fun provideColorGenerator(): ColorGenerator

    fun inject(fragment : FragmentProducer)

    @Component.Factory
    interface Factory {

        fun create(activityComponent : MainActivityComponent) : ProducerComponent
    }
}
