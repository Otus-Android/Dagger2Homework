package ru.otus.daggerhomework.di

import dagger.Module

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
class ApplicationSubcomponents
