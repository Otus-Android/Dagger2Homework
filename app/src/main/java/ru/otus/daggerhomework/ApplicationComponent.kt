package ru.otus.daggerhomework

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.ApplicationModule
import ru.otus.daggerhomework.di.MainActivityModule
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun provideApplication(): Application

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }

}