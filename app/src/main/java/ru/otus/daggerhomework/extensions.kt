package ru.otus.daggerhomework

import android.content.Context
import android.content.ContextWrapper

inline fun <reified T> Any.dangerCast(): T = this as T

@Suppress("RecursivePropertyAccessor")
val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }

@Suppress("RecursivePropertyAccessor")
val Context.mainActivityComponent: MainActivityComponent
    get() = when (this) {
        is MainActivity -> mainComponent
        is ContextWrapper -> baseContext.mainActivityComponent
        else -> throw NotImplementedError()
    }