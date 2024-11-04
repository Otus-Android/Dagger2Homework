package ru.otus.daggerhomework.fragments

import dagger.Module
import javax.inject.Scope


@Module(subcomponents = [FragmentReceiveComponent::class, FragmentProducerComponent::class])
interface FragmentComponentsModule

@Scope
annotation class FragmentScope