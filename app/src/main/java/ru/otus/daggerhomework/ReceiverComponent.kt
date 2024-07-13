package ru.otus.daggerhomework

import dagger.Component
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
)
interface ReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Component.Factory
    interface Factory {

        fun create(activityComponent : MainActivityComponent) : ReceiverComponent
    }
}
