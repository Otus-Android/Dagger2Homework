package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.receiver.FragmentReceiver

@Component
interface FragmentComponent {

    fun injectFragmentReceiver(fragment: FragmentReceiver)
    fun injectFragmentProducer(fragment: FragmentProducer)
}