package ru.otus.daggerhomework.di

import android.content.Context
import ru.otus.daggerhomework.App

val Context.appComponent: ApplicationComponent
    get() = when(this){
        is App -> applicationComponent
        else -> this.applicationContext.appComponent
    }