package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

const val NAME_APP_CONTEXT = "appContext"

@Singleton
@Component
interface ApplicationComponent : MainActivityDependencies {
    
    @Component.Factory
    interface Factory {
        fun create(
            @Named(NAME_APP_CONTEXT)
            @BindsInstance context: Context
        ): ApplicationComponent
    }
    
}