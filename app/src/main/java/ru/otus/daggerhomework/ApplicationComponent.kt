package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Singleton

@Module()
interface ApplicationModule {

}

@Qualifier
annotation class ApplicationContext

@Component
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
