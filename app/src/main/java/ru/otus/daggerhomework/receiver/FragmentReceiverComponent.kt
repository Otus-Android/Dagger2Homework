package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.di.MainActivityComponent

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun provideViewModelReceiver(): ViewModelReceiver

    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent
                .builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
        }
    }
}
