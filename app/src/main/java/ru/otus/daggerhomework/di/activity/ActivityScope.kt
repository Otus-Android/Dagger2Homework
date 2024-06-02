package ru.otus.daggerhomework.di.activity

import javax.inject.Scope

@Scope
//@Retention(AnnotationRetention.BINARY)
// Можно не использовать, даггеру в рантайме они не нужны, достаточно дефолтного Ретеншена
annotation class ActivityScope