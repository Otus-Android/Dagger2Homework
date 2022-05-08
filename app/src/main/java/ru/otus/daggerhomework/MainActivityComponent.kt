package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = [ApplicationComponent::class],
modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun crete(
            @ActivityContext @BindsInstance context: Context,
            applicationComponent: ApplicationComponent,
        ): MainActivityComponent
    }


    fun inject(activity: MainActivity)

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideState(): MutableStateFlow<Int>
}

@Module
interface MainActivityModule {
    companion object {
        @Provides
        @ActivityScope
        fun provideState() = MutableStateFlow(0)
    }
}
