package ru.otus.daggerhomework.di.module

import dagger.Module
import ru.otus.daggerhomework.di.component.MainActivityComponent

@Module(subcomponents = [MainActivityComponent::class])
class ApplicationModule {
}