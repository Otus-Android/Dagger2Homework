package ru.otus.daggerhomework.di.utils.scopes

import javax.inject.Scope

/**
 * Индикатор области существования зависимостей `Activity`
 */
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
