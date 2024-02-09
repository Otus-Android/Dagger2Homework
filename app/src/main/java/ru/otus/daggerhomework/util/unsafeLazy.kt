package ru.otus.daggerhomework.util

inline fun <T> unsafeLazy(crossinline initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE) { initializer() }
