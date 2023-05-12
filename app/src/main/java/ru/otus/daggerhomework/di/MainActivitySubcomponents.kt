package ru.otus.daggerhomework.di

import dagger.Module
import ru.otus.daggerhomework.FragmentProducerComponent
import ru.otus.daggerhomework.FragmentReceiverComponent

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface MainActivitySubcomponents {
}