package ru.otus.daggerhomework.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.*
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainModule::class]
)
interface MainActivityComponent {

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideGetColorValue(): GetColorValue

    fun provideSetColorValue(): SetColorValue

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent,
        ): MainActivityComponent
    }
}
