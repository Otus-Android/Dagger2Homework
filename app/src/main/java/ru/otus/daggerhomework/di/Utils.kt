package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.App

val Context.appComponent: ApplicationComponent
    get() = when(this){
        is App -> applicationComponent
        else -> this.applicationContext.appComponent
    }
/*
val Context.activityComponent: MainActivityComponent
    get() = when(this){
        is AppCompatActivity -> applicationComponent
        else -> throw IllegalStateException()
    }*/