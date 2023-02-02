package ru.otus.daggerhomework.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.MainActivity

@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun provideMainActivity(): MainActivity

    fun provideApplication(): Application

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent,
                   @BindsInstance mainActivity: MainActivity): MainActivityComponent
    }

}