package ru.otus.daggerhomework.di.component

import dagger.Subcomponent
import ru.otus.daggerhomework.di.scope.FragmentScope
import ru.otus.daggerhomework.receiver.FragmentReceiver

@FragmentScope
@Subcomponent
interface FragmentReceiverComponent {

    fun injectFragmentReceiver(fragment: FragmentReceiver)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentReceiverComponent
    }
}