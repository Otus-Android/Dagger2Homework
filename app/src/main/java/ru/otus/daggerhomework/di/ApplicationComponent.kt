package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {
    @ApplicationContext
    fun applicationContext(): Context
    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext applicationContext: Context): ApplicationComponent
    }
}
