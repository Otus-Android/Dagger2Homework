package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.Constants.ACTIVITY_CONTEXT
import javax.inject.Named

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [FlowModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @Named(ACTIVITY_CONTEXT) activityContext: Context,
        ): MainActivityComponent
    }

    @Named(ACTIVITY_CONTEXT)
    fun provideActivityContext() : Context


    @Named(Constants.APP_CONTEXT)
    fun provideContext(): Context

    fun provideFlow(): StateFlow<Int?>

    fun provideMutableFlow(): MutableStateFlow<Int?>

    fun inject(mainActivity: MainActivity)
}
