package ru.otus.daggerhomework.di

import dagger.Module

@Module(
    subcomponents = [
        MainActivityComponent::class
    ]
)
class AppSubcomponents

@Module(
    subcomponents = [
        FragmentReceiverComponent::class,
        FragmentProducerComponent::class
    ]
)
class ActivitySubcomponents
