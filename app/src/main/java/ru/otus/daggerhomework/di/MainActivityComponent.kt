package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface MainActivityComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create (@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context
}
