package ru.otus.daggerhomework

import dagger.Component

@FragmentColorScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    companion object{
        fun getFragmentReceiverComponent(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent{
            return DaggerFragmentReceiverComponent.builder().mainActivityComponent(mainActivityComponent).build()
        }
    }

    fun inject(fragment: FragmentReceiver)

}