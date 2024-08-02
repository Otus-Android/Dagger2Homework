package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorRepositoryReadOnly
import ru.otus.daggerhomework.ColorRepositoryWriteOnly

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ColorRepositoryModule::class]
)
@ActivityScope
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorRepositoryReadOnly(): ColorRepositoryReadOnly

    fun provideColorRepositoryWriteOnly(): ColorRepositoryWriteOnly
}