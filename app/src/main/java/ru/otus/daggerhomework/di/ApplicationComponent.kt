package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named


@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun mainActivityComponentFactory(): MainActivityComponent.Factory


    @Component.Factory
    interface ApplicationComponentFactory {

        fun create (@BindsInstance @Named("ApplicationContext") context: Context) : ApplicationComponent
    }



}

