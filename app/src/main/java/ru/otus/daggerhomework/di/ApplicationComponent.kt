package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationSubComponentsModule::class]
)
interface ApplicationComponent {

    fun mainActivityComponent(): MainActivityComponent.Factory
}

@Module(
    subcomponents = [MainActivityComponent::class]
)
interface ApplicationSubComponentsModule
