package ru.otus.daggerhomework.applicaion

import android.app.Application

class App : Application() {

    val appComponent: ApplicationComponent = DaggerApplicationComponent.factory().create(this)

}