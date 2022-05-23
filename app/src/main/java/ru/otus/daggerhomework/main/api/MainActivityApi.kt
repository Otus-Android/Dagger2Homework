package ru.otus.daggerhomework.main.api

import android.content.Context
import ru.otus.daggerhomework.MutableEventObservable

interface MainActivityApi {
    fun provideApplicationContext(): Context
    fun provideActivityContext(): Context
    val eventObservable: MutableEventObservable
}