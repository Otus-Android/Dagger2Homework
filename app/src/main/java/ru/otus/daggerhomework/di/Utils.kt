package ru.otus.daggerhomework.di

import android.content.Context
import ru.otus.daggerhomework.App

val Context.applicationComponent: ApplicationComponent
    get() = when(this){
        is App -> applicationComponent
        else -> this.applicationContext.applicationComponent
    }