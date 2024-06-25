package ru.otus.daggerhomework

import dagger.Component
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ReceiverModule::class]
)
interface ReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Component.Factory
    interface Factory {

        fun create(activityComponent : MainActivityComponent) : ReceiverComponent
    }
}
