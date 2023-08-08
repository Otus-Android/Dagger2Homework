package ru.otus.daggerhomework.di.utils.qualifiers

import javax.inject.Qualifier

/**
 * Индикатор `Application` контекста
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext
