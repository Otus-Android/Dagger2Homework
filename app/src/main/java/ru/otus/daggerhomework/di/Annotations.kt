package ru.otus.daggerhomework.di

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
annotation class ApplicationContext

@Qualifier
annotation class ActivityContext

@Scope
annotation class MainActivityScope

@Scope
annotation class ProducerComponentScope