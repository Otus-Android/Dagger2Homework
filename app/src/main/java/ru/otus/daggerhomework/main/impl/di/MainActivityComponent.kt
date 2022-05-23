package ru.otus.daggerhomework.main.impl.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.common.ActivityScope
import ru.otus.daggerhomework.common.NeedInitializeException
import ru.otus.daggerhomework.main.api.MainActivityApi
import javax.inject.Named

@Component
@ActivityScope
interface MainActivityComponent : MainActivityApi {

    @Named(APPLICATION_CONTEXT_QUALIFIER)
    override fun provideApplicationContext(): Context

    @Named(ACTIVITY_CONTEXT_QUALIFIER)
    override fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named(APPLICATION_CONTEXT_QUALIFIER) applicationContext: Context,
            @BindsInstance @Named(ACTIVITY_CONTEXT_QUALIFIER) activityContext: Context
        ): MainActivityComponent
    }

    companion object {
        const val APPLICATION_CONTEXT_QUALIFIER = "mainActivityComponentApplicationContext"
        const val ACTIVITY_CONTEXT_QUALIFIER = "mainActivityComponentActivityContext"

        private var mInstance: MainActivityComponent? = null
        private var mApplicationContextProvider: () -> Context = {
            throw NeedInitializeException()
        }

        fun init(applicationContextProvider: () -> Context) {
            mApplicationContextProvider = applicationContextProvider
        }

        fun create(activityContext: Context) {
            DaggerMainActivityComponent.factory()
                .create(
                    applicationContext = mApplicationContextProvider(),
                    activityContext = activityContext
                ).apply { mInstance = this }
        }

        fun getInstance() = mInstance ?: throw NeedInitializeException()

        fun release() {
            mInstance = null
        }

    }

}