package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.annotation.Application
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {

    fun provideColorGenerator(): ColorGenerator

    @Application
    fun provideApplicationContext(): Context

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}
