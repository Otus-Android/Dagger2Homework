package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.*
import javax.inject.Singleton

@Singleton
@Component(modules = [ FragmentsModule::class, ColorGeneratorModule::class, ObserverModule::class],
    dependencies = [ApplicationComponent::class])
interface MainActivityComponent  {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance context: Context
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun provideContext(): Context
}