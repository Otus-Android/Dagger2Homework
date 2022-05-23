package ru.otus.daggerhomework.main.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.MutableEventObservable
import ru.otus.daggerhomework.common.ActivityScope
import ru.otus.daggerhomework.common.NeedInitializeException
import ru.otus.daggerhomework.producer.di.FragmentProducerComponent
import javax.inject.Named

@Component(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {

    @Named(APPLICATION_CONTEXT_QUALIFIER)
    fun provideApplicationContext(): Context
    @Named(ACTIVITY_CONTEXT_QUALIFIER)
    fun provideActivityContext(): Context
    val eventObservable: MutableEventObservable
    //val producerComponent: FragmentProducerComponent

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named(APPLICATION_CONTEXT_QUALIFIER) applicationContext: Context,
            @BindsInstance @Named(ACTIVITY_CONTEXT_QUALIFIER) activityContext: Context
        ): MainActivityComponent
    }

    companion object {
        const val APPLICATION_CONTEXT_QUALIFIER = "1applicationContext"
        const val ACTIVITY_CONTEXT_QUALIFIER = "1activityContext"

        private var mInstance: MainActivityComponent? = null

        fun init(
            applicationContext: Context,
            activityContext: Context
        ) {
            mInstance = DaggerMainActivityComponent.factory()
                .create(
                    applicationContext = applicationContext,
                    activityContext = activityContext
                )
        }

        fun getInstance() = mInstance ?: throw NeedInitializeException()

        fun release() {
            mInstance = null
        }

    }

}