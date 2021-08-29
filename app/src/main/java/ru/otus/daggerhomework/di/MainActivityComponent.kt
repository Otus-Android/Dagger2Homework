package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Named


@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
@ActivityScope
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @Named("activityContext") @BindsInstance activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @Named("activityContext")
    fun provideActivityContext(): Context

    @Named("applicationContext")
    fun provideApplicationContext(): Context

    fun provideEventChannel(): MutableSharedFlow<Int>

}