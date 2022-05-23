package ru.otus.daggerhomework.receiver.di

import ru.otus.daggerhomework.EventObservable

interface ReceiverDependency {
    fun provideEventObservable(): EventObservable
}