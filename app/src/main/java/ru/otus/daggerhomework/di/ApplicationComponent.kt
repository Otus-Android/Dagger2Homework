package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.qualifiers.ApplicationQualifier
import ru.otus.daggerhomework.di.scopes.ApplicationScope

@ApplicationScope
@Component
interface ApplicationComponent {

    @ApplicationQualifier
    fun getApplicationContext(): Context

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            @ApplicationQualifier
            applicationContext: Context
        ): ApplicationComponent
    }
}