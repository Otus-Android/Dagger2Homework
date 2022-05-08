package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class])
interface FragmentReceiverComponent {
    companion object {

        fun create (component: ApplicationComponent, activityComponent: MainActivityComponent) =
            DaggerFragmentReceiverComponent
                .builder()
                .applicationComponent(component)
                .mainActivityComponent(activityComponent)
                .build()
    }
    fun inject(fragment: FragmentReceiver)
}