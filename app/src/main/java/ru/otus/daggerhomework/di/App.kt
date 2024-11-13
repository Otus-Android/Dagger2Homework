package ru.otus.daggerhomework.di

import android.app.Application

class App : Application() {

    val component by lazy { DaggerApplicationComponent.factory().create(this) }

}