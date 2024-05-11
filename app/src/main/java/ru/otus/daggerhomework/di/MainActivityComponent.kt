package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorStorageRepository

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

    fun provideColorStorageRepository(): ColorStorageRepository

    @Component.Factory
    interface MainActivityFactory {
        fun create(
            applicationComponent: ApplicationComponent,
            @ActivityContext @BindsInstance context: Context,
        ): MainActivityComponent
    }
}
