package ru.otus.daggerhomework.di.application

import dagger.Module
import ru.otus.daggerhomework.di.activity.MainActivityComponent


@Module(subcomponents = [MainActivityComponent::class])
interface ApplicationModule