package ru.otus.daggerhomework.di

import android.app.Activity
import android.app.Application
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.MainActivityState
import javax.inject.Scope

@Scope
annotation class ActivityScope

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
)
interface ActivityComponent : AppProvider {
    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance activity: Activity,
            @BindsInstance activityState: MainActivityState,
        ): ActivityComponent
    }

    fun provideActivity(): Activity
    fun provideMainActivityState(): MainActivityState
}

interface ActivityComponentProvider {
    fun provideActivityComponent(): ActivityComponent
}

