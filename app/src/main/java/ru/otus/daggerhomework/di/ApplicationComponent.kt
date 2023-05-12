package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ApplicationSubcomponents::class, ColorGeneratorModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@ApplicationContext @BindsInstance context: Context): ApplicationComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory
}