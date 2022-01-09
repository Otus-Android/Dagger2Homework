package ru.otus.daggerhomework.di.components

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.modules.appModule.AppModule
import ru.otus.daggerhomework.di.modules.viewModels.ViewModelFactory
import ru.otus.daggerhomework.views.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @ApplicationContext
            @BindsInstance context: Context): AppComponent
    }
    @ApplicationContext
    fun provideContext(): Context
    fun provideColorGenerator(): ColorGenerator

}
@Scope
annotation class AppScope
@Qualifier
annotation class ApplicationContext