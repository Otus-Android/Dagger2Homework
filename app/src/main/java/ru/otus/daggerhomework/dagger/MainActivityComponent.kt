package ru.otus.daggerhomework.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorObserver

@MainActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    fun activityContext(): Context

    fun colorObserver(): ColorObserver
}
