package ru.otus.daggerhomework.di.utils.qualifiers

import javax.inject.Qualifier

/**
 * Индикатор `Activity` контекста
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext
