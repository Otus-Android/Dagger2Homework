package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver
import javax.inject.Named

@Subcomponent(
//    dependencies = [ApplicationComponent::class],
    modules = [ViewModelsModule::class]
)
interface FragmentReceiverComponent {

    @Subcomponent.Builder
    interface Builder {
        fun create (): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}