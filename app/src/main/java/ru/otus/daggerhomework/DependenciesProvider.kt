package ru.otus.daggerhomework

interface DependenciesProvider<out T> {
    fun getDependencies(): T
}