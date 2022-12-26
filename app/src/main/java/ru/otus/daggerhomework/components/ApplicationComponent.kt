package ru.otus.daggerhomework.components

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.modules.ColorGeneratorModule
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes_and_qualifiers.AppContext
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    fun inject(app: App)

    @AppContext
    fun provideApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance
                   @AppContext
                   context: Context): ApplicationComponent
    }
}