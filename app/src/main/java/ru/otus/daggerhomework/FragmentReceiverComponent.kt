package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {
    companion object {

        fun create (component: ApplicationComponent) =
            DaggerFragmentReceiverComponent
                .builder()
                .applicationComponent(component)
                .build()
    }
    fun inject(fragment: FragmentReceiver)
}