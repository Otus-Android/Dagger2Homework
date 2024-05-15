package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.EventObserver
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.ApplicationContext


@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext activityContext: Context,
            @BindsInstance eventObserver: EventObserver,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
    @ApplicationContext
    fun provideContext(): Context
    @ActivityContext
    fun provideActivityContext(): Context

    fun provideEventObserver(): EventObserver
    fun inject(activity: MainActivity)
}