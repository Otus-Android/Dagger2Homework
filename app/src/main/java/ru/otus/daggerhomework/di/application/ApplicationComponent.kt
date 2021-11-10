package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.activity.MainActivityComponent
import ru.otus.daggerhomework.di.qualifiers.AppContext
import ru.otus.daggerhomework.di.scopes.ApplicationScope

@Component(modules = [ApplicationModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun activityComponent(): MainActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @AppContext
            @BindsInstance
            context: Context
        ): ApplicationComponent
    }
}


