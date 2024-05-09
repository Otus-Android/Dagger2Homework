package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@MainActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @Named("activityContext")
    fun provideContext(): Context

    @Named("applicationContext")
    fun provideApplicationContext(): Context

    fun provideMutableStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @Named("activityContext")
            context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    companion object {
        fun create(
            context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(context, applicationComponent)
        }
    }

    fun inject(activity: MainActivity)
}

@Module
interface MainActivityModule {

    companion object {
        @MainActivityScope
        @Provides
        fun provideStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }
}