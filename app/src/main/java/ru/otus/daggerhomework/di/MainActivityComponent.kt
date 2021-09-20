package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.di.scopes.CustomActivityScope
import javax.inject.Named

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
@CustomActivityScope
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

    @Named("appContext")
    fun provideApplicationContext(): Context

    fun provideEventChannel(): MutableSharedFlow<Int>
}