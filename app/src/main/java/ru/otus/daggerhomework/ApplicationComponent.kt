package ru.otus.daggerhomework

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope

@Singleton
@Component
interface ApplicationComponent {

    fun provideApplication(): Application

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }

}