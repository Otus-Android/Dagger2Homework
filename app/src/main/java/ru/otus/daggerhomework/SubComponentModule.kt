package ru.otus.daggerhomework

import dagger.Module

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface SubComponentModule