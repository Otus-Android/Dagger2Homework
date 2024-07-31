package ru.otus.daggerhomework.di

import dagger.Module
import ru.otus.daggerhomework.di.main.MainActivityComponent

@Module(subcomponents = [MainActivityComponent::class])
interface ApplicationSubcomponentsModule