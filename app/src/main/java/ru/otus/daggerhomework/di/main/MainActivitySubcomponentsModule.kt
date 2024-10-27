package ru.otus.daggerhomework.di.main

import dagger.Module
import ru.otus.daggerhomework.di.producer.FragmentProducerComponent
import ru.otus.daggerhomework.di.receiver.FragmentReceiverComponent

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface MainActivitySubcomponentsModule