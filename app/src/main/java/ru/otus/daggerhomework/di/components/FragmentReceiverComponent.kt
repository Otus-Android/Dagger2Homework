package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.di.dependencies.FragmentReceiverDependencies
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver
import ru.otus.daggerhomework.utils.FragmentScope

@FragmentScope
@Component(dependencies = [FragmentReceiverDependencies::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

}
