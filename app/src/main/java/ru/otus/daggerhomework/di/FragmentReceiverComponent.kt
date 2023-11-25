package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FeaturedScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
    @ActivityContext
    fun context(): Context

    @Component.Factory
    interface Factory{
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}