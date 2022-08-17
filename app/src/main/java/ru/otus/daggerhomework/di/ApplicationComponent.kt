package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.*
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
@Component
interface ApplicationComponent {

    @ApplicationContext
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): ApplicationComponent
    }
}

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Qualifier
annotation class ApplicationContext