package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.FragmentScope
import ru.otus.daggerhomework.ViewModelModule

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [ViewModelModule::class])
interface FragmentReceiverComponent {

    fun injectFragmentReceiver(fragment: FragmentReceiver)
}