package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationAggregatingModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun addMainActivityComponent(): MainActivityComponent.Factory
}

@Module(subcomponents = [MainActivityComponent::class])
interface ApplicationAggregatingModule