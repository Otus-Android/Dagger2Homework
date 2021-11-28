package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.qualifiers.ApplicationScope


@Component
interface ApplicationComponent {

    @ApplicationScope
    fun applicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@ApplicationScope @BindsInstance appContext: Context): ApplicationComponent
    }

}