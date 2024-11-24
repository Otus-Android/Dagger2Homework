package ru.otus.daggerhomework.di.receiver

import dagger.Component
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.di.application.FragmentScope

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class]
)
interface ReceiverComponent {

    companion object {
        fun getReceiverComponent(activityComponent: ActivityComponent): ReceiverComponent {
            return DaggerReceiverComponent.builder().activityComponent(activityComponent).build()
        }
    }

    fun inject(receiverFragment: FragmentReceiver)
}