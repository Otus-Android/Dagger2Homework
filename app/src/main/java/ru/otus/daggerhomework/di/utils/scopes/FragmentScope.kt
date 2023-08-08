package ru.otus.daggerhomework.di.utils.scopes

import javax.inject.Scope

/**
 * Индикатор области существования зависимостей `Fragment`-а
 */
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope
