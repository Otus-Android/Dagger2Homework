package ru.otus.daggerhomework.activity

import android.content.Context
import androidx.lifecycle.LifecycleCoroutineScope
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.utils.Notification

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideNotification(): Notification

    fun provideActivityLifecycleScope(): LifecycleCoroutineScope

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addActivityContext(
            @ActivityContext activityContext: Context
        ): Builder

        @BindsInstance
        fun addActivityLifecycleScope(
            lifecycleScope: LifecycleCoroutineScope
        ): Builder

        fun addApplicationComponent(
            applicationComponent: ApplicationComponent
        ): Builder

        fun create(): MainActivityComponent
    }
}