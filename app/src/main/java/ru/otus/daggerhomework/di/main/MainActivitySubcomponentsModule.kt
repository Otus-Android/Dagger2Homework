package ru.otus.daggerhomework.di.main

import dagger.Module
import ru.otus.daggerhomework.di.producer.FragmentProducerComponent
import ru.otus.daggerhomework.di.receiver.FragmentReceiverComponent

/**
 * `Dagger` [Module] `subcomponent`-ов главного экрана
 */
@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface MainActivitySubcomponentsModule