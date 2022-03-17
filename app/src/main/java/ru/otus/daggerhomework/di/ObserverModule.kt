package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Singleton


@Module
class ObserverModule {

    @Singleton
    @Provides
    fun providePublishSubject(): PublishSubject<Int> {
        return PublishSubject.create<Int>()
    }
}