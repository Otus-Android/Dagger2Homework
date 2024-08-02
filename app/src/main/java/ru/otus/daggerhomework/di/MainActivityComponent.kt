package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.IColorRepositoryReadOnly
import ru.otus.daggerhomework.IColorRepositoryWriteOnly

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

    fun provideColorRepositoryReadOnly(): IColorRepositoryReadOnly

    fun provideColorRepositoryWriteOnly(): IColorRepositoryWriteOnly
}