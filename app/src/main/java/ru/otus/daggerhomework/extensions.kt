package ru.otus.daggerhomework

inline fun <reified T> Any.dangerCast(): T = this as T
