package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named
import javax.inject.Scope


const val MAIN_ACTIVITY_CONTEXT = "mainActivityContext"

@Scope
annotation class ActivityScope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @Named(MAIN_ACTIVITY_CONTEXT)
            @BindsInstance context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @Named(MAIN_ACTIVITY_CONTEXT)
    fun provideActivityContext(): Context

    @Named(APPLICATION_CONTEXT)
    fun provideApplicationContext(): Context

    fun provideColorState(): MutableStateFlow<Int>

}