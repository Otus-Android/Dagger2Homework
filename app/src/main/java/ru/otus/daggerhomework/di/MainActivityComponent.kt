package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ColorRepositoryModule::class]
)
@ActivityScope
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}