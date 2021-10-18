package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.ColorModule
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentScope

@FragmentScope
@Component(modules = [ColorModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun injectFragmentProducer(fragment: FragmentProducer)

}