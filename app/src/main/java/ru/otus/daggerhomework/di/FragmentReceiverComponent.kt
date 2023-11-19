package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ui.FragmentReceiver
import ru.otus.daggerhomework.di.scopes.FragmentScope

@FragmentScope
@Component(modules = [ViewModelModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun getFragmentReceiverComponent(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.factory().create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}