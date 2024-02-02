package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    companion object{
        fun getFragmentReceiverComponent(applicationComponent: ApplicationComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder().applicationComponent(applicationComponent).build()
        }
    }
}