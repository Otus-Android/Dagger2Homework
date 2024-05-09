package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Named

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @Named("applicationContext")
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}

@Module
interface ApplicationModule {

    @Binds
    @Named("applicationContext")
    fun bindContext(application: Application): Context
}