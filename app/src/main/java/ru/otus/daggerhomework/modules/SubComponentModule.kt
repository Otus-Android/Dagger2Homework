package ru.otus.daggerhomework.modules

import dagger.Module
import ru.otus.daggerhomework.components.FragmentProducerComponent
import ru.otus.daggerhomework.components.FragmentReceiverComponent
import ru.otus.daggerhomework.components.MainActivityComponent

@Module(subcomponents = [MainActivityComponent::class, FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface SubComponentModule