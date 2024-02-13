package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.MyObServer
import javax.inject.Qualifier
import javax.inject.Scope


@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {

        fun create(applicationComponent: ApplicationComponent,
                   @BindsInstance @ActivityContext context: Context
                   ): MainActivityComponent
    }


    fun provideObserver(): MyObServer

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context
    fun inject(mainActivity: MainActivity)


}

