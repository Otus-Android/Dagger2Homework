package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorsDataStore
import ru.otus.daggerhomework.ColorsDataStoreMutable
import ru.otus.daggerhomework.ColorsDataStoreUnmutable
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

    fun providesColorsDataStoreMutable(): ColorsDataStoreMutable

    fun providesColorsDataStoreUnmutable(): ColorsDataStoreUnmutable
}

@Module
interface ApplicationModule {
    companion object {
        @Provides
        @ApplicationContext
        fun provideApplicationContext(applicationContext: Context): Context = applicationContext
    }

    @Binds
    fun bindColorDataStoreMutable(impl: ColorsDataStore): ColorsDataStoreMutable

    @Binds
    fun bindColorDataStoreUnmutable(impl: ColorsDataStore): ColorsDataStoreUnmutable
}