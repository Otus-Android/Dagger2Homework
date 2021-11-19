package ru.otus.daggerhomework.di

import android.content.Context
import ru.otus.daggerhomework.utils.ApplicationContext

interface ApplicationDeps {
    @ApplicationContext
    fun application(): Context
}