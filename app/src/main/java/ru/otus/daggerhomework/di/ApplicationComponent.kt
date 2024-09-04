package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorsDataStore
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    @ApplicationContext
    fun provideApplicationContext1(): Context

    fun providesColorsDataStore() = ColorsDataStore()
}

@Module
object ApplicationModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplicationContext(applicationContext: Context): Context = applicationContext

    @Provides
    @Singleton
    fun providesColorsDataStore() = ColorsDataStore()
}