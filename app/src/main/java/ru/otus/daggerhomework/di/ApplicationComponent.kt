package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.annotations.ApplicationContext
import ru.otus.daggerhomework.di.annotations.ApplicationScope

@ApplicationScope
@Component(modules = [MainActivityModule::class])
interface ApplicationComponent {

    fun mainActivityComponent(): MainActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @ApplicationContext
            @BindsInstance
            context: Context
        ): ApplicationComponent
    }
}