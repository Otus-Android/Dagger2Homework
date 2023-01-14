package ru.otus.daggerhomework.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@AppContext @BindsInstance applicationContext: Context): ApplicationComponent
    }

    @AppContext
    fun applicationContext(): Context
}
