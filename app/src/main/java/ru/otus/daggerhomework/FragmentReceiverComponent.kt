package ru.otus.daggerhomework

import android.content.Context
import dagger.Component

@FeaturedScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
    @MainActivityContext
    fun context(): Context

    @Component.Factory
    interface Factory{
        fun create(mainActivityComponent: MainActivityComponent):FragmentReceiverComponent
    }
}