package ru.otus.daggerhomework.di.dependencies

interface DependenciesProvider<out T> {
    fun getDependencies(): T
}