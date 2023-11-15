package ru.otus.daggerhomework.di

import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.Flow

@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

   /* @Component.Factory
    interface Factory {
        fun create(@BindsInstance flow: Flow<Int>): MainActivityComponent
    }*/
}