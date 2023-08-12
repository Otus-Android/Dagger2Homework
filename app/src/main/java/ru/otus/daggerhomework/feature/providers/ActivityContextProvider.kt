package ru.otus.daggerhomework.feature.providers

import android.content.Context
import ru.otus.daggerhomework.qualifier.ActivityContext

interface ActivityContextProvider {
    @ActivityContext
    fun provideActivityContext(): Context
}