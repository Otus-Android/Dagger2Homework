package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@Component(
    modules = [ViewModelModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FragmentReceiverComponent {

    //fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun getFragmentReceiverComponent(applicationComponent: ApplicationComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder().applicationComponent(applicationComponent).build()
        }
    }
}