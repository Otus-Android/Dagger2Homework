package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides

@Component(
    dependencies = [ApplicationComponent::class],
)
interface MainActivityComponent {

    @ApplicationContext
    fun provideApplicationContext(): Context
    @Component.Factory
    interface MainActivityComponentFactory {
        fun create(
            @BindsInstance context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}