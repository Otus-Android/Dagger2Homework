package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @AppContext
    fun provideAppContext(): Context

    fun provideContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideColorObserver(): ColorObserver

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            applicationComponent: ApplicationComponent,
        ): MainActivityComponent
    }
}
