package ru.otus.daggerhomework.applicaion

import android.app.Application

class App : Application() {

    internal val appComponent: ApplicationComponent =
        DaggerApplicationComponent
            .factory()
            .create(this, FlowModule())

}