package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton

@Qualifier
annotation class QualifierAppContext

@Scope
annotation class FragmentScope

@Singleton
@Component
interface ApplicationComponent {

    @QualifierAppContext
    fun provideAppContext(): Context

    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @QualifierAppContext
            @BindsInstance
            applicationContext: Context
        ): ApplicationComponent
    }
}