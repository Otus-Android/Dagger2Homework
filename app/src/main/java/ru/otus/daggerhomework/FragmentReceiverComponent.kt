package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [MainActivityComponent::class])
@FragmentScope
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }

}