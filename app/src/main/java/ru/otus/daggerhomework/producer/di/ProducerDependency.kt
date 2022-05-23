package ru.otus.daggerhomework.producer.di

import ru.otus.daggerhomework.MutableEventObservable

interface ProducerDependency {
    fun provideEventObservable(): MutableEventObservable
}