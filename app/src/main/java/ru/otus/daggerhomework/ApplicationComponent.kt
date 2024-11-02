package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

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