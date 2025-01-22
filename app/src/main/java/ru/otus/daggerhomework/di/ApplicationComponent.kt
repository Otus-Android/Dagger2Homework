package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubcomponentsModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create (
            @BindsInstance
            @Named ("AppContext")
            context: Context
        ): ApplicationComponent
    }

    fun addMainActivityComponent(): MainActivityComponent.Factory

    fun inject(activity: MainActivity)

}

@Module (subcomponents = [MainActivityComponent::class])
interface AppSubcomponentsModule