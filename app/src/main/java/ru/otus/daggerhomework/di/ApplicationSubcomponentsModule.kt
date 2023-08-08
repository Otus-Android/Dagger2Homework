package ru.otus.daggerhomework.di

import dagger.Module
import ru.otus.daggerhomework.di.main.MainActivityComponent

/**
 * `Dagger` [Module] `subcomponent`-ов приложения
 */
@Module(subcomponents = [MainActivityComponent::class])
interface ApplicationSubcomponentsModule