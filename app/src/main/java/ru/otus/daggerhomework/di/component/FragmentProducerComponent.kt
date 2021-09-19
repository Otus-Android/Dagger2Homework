package ru.otus.daggerhomework.di.component

import dagger.Subcomponent
import ru.otus.daggerhomework.di.scope.FragmentScope
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver

@FragmentScope
@Subcomponent
interface FragmentProducerComponent {

    fun injectFragmentProducer(fragment: FragmentProducer)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentProducerComponent
    }
}