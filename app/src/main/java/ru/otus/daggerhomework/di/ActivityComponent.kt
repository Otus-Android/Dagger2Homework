package ru.otus.daggerhomework.di

import android.app.Activity
import android.app.Application
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
    modules = [ActivityModule::class],
)
interface ActivityComponent {
    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance activity: Activity,
        ): ActivityComponent
    }

    fun getApplicationContext(): Application
    fun getActivityContext(): Activity
    fun provideMainActivityState(): MainActivityState
}

@Module
interface ActivityModule {
    fun getActivityContext(): Activity
    companion object {
        @ActivityScope
        @Provides
        fun createMainActivityState(): MainActivityState {
            return MainActivityState()
        }
    }
}

interface ActivityComponentProvider {
    fun provideActivityComponent(): ActivityComponent
}