package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.module.ApplicationModule
import javax.inject.Named
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    fun mainActivityComponentBuild(): MainActivityComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@Named("appContext") context: Context): Builder

        fun build(): ApplicationComponent
    }
}