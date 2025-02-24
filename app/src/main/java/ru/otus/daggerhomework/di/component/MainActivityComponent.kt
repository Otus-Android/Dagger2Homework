package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.di.scope.ActivityScope
import ru.otus.daggerhomework.di.module.MainActivityModule
import javax.inject.Named


@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)

interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun build(
            appComponent: ApplicationComponent,
            @BindsInstance
            @Named("activityContext")
            context: Context
        ): MainActivityComponent
    }

    fun provideColorState(): ColorState

    @Named("appContext")
    fun provideAppContext(): Context

    @Named("activityContext")
    fun provideActivityContext(): Context
}