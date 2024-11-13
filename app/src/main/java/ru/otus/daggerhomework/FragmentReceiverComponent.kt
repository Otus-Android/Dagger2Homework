package ru.otus.daggerhomework

import dagger.Component

@Component(
    modules = [FragmentReceiverModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FragmentReceiverComponent {

    companion object {
        fun getFragmentReceiverComponent(applicationComponent: ApplicationComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .applicationComponent(applicationComponent).build()
        }
    }
}