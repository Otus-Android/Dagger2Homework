package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@AppScope
@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)


    fun provideMyViewModel(): MyViewModel


    fun provideColorGenerator(): ColorGenerator


    fun provideContext(): Context

    @Component.Factory
    interface AppComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}