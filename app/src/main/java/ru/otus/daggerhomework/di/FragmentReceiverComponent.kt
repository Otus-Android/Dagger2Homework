package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ViewModelReceiverFactory

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun getViewModelFactory(): ViewModelReceiverFactory

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}
