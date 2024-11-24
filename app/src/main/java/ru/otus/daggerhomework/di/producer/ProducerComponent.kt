package ru.otus.daggerhomework.di.producer

import dagger.Component
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.application.FragmentScope

@FragmentScope
@Component(
    modules = [ColorGeneratorModule::class],
    dependencies = [ActivityComponent::class]
)
interface ProducerComponent {

    companion object {
        fun getProducerComponent(activityComponent: ActivityComponent): ProducerComponent {
            return DaggerProducerComponent.builder().activityComponent(activityComponent).build()
        }
    }

    fun inject(producerFragment: FragmentProducer)

}