package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.GetColorRepository
import ru.otus.daggerhomework.SetColorRepository

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideGetColorRepository(): GetColorRepository
    fun provideSetColorRepository(): SetColorRepository

    @Component.Factory
    interface MainActivityFactory {
        fun create(
            applicationComponent: ApplicationComponent,
            @ActivityContext @BindsInstance context: Context,
        ): MainActivityComponent
    }
}
