package ru.otus.daggerhomework


import dagger.Component

@MyScope
@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    companion object{
        fun getFragmentReceiverComponent(applicationComponent: ApplicationComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder().applicationComponent(applicationComponent).build()
        }
    }
}