package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.presentation.receiver.ViewModelReceiver

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    val viewModelFactory: ViewModelReceiver.Factory
    @get:AppContext val appContext: Context

    @Component.Factory
    interface Factory {

        fun create(
            component: MainActivityComponent
        ): FragmentReceiverComponent
    }

    companion object {

        fun factory(): FragmentReceiverComponent.Factory = DaggerFragmentReceiverComponent.factory()
    }
}
