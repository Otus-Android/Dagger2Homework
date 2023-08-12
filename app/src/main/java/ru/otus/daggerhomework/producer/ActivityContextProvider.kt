package ru.otus.daggerhomework.producer

import android.content.Context
import ru.otus.daggerhomework.qualifier.ActivityContext

interface ActivityContextProvider {
    @ActivityContext
    fun provideActivityContext(): Context
}