package ru.otus.daggerhomework.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ActivityScope
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.EventBus
import ru.otus.daggerhomework.MainActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun provideMainActivity(): Context

    fun provideApplication(): Application

    fun provideEventBus(): EventBus

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent,
                   @BindsInstance mainActivity: Context): MainActivityComponent
    }

}