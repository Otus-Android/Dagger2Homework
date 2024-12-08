package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@Component(
    modules = [ViewModelReceiverModule::class],
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentReceiverComponent {
    companion object {
        fun getInstance(activityComponent: MainActivityComponent): FragmentReceiverComponent =
            DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()
    }

    fun inject(fragmentReceiverComponent: FragmentReceiver)
}