package ru.otus.daggerhomework.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.qualifier.ActivityContext

@Component
interface MainActivityComponent {
    @Component.Factory
    interface ContextFactory {
        fun create(@BindsInstance @ActivityContext context: Context) : MainActivityComponent
    }

    companion object {
        fun getMainActivityComponent(context: Context) : MainActivityComponent =
            DaggerMainActivityComponent.factory().create(context)
    }

    @ActivityContext
    fun provideAppContext(): Context
}