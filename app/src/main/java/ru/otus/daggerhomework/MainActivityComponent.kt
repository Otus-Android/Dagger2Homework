package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named

@MainActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Named("act")
    fun provideContext(): Context

    fun provideEvent(): Event<Int>

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance @Named("act") context: Context): MainActivityComponent
    }
}

@Module
class MainActivityModule {

    @MainActivityScope
    @Provides
    fun provideEvent() = Event<Int>()
}
