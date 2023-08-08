package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.main.MainActivityComponent
import ru.otus.daggerhomework.di.utils.qualifiers.ApplicationContext

/**
 * `Dagger` [Component] приложения
 */
@Component(modules = [ApplicationSubcomponentsModule::class])
interface ApplicationComponent {

    /** Фабрика `Dagger` [Component]-а главного экрана */
    val mainActivityComponentFactory: MainActivityComponent.Factory

    /** Фабрика `Dagger` [Component]-а приложения */
    @Component.Factory
    interface Factory {

        /** Создать [ApplicationComponent] на основе `Application` контекста [context] */
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}