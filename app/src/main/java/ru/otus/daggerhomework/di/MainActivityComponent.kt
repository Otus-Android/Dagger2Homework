package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.MyObServer


@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }


    fun provideObserver(): MyObServer.Observe
    fun provideObserverSend(): MyObServer.Send


    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context
    fun inject(mainActivity: MainActivity)


}

