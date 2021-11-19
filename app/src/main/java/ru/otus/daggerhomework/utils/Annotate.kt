package ru.otus.daggerhomework.utils

import javax.inject.Qualifier
import javax.inject.Scope


@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope

@Qualifier
annotation class ApplicationContext