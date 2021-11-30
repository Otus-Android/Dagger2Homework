package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import javax.inject.Named

@MainActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Named("act")
    fun provideContext(): Context

    fun provideEventHandler(): Channel<Int>

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @Named("act") context: Context): MainActivityComponent
    }
}

@Module
class MainActivityModule {

    @MainActivityScope
    @Provides
    fun provideEventHandler() = Channel<Int>()
}
