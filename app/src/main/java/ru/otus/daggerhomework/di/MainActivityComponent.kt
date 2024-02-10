package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@MainActivityScope
@Component(dependencies = [AppComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @AppContext
    fun appContext(): Context

    fun activityContext(): Context

    fun mutableStateFlow(): MutableStateFlow<Int>

    fun flow(): Flow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            mainActivityContext: Context,
            appComponent: AppComponent,
        ): MainActivityComponent
    }
}