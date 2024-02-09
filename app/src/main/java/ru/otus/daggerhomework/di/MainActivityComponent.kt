package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.util.EventFlow
import ru.otus.daggerhomework.util.EventSender
import javax.inject.Qualifier

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @get:AppContext
    val appContext: Context

    @get:ActivityContext
    val activityContext: Context

    val eventFlow: EventFlow
    val eventProducer: EventSender

    @Component.Factory
    interface Factory {

        fun create(
            component: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context,
        ): MainActivityComponent
    }

    companion object {

        fun factory(): MainActivityComponent.Factory = DaggerMainActivityComponent.factory()
    }
}

@Qualifier
annotation class ActivityContext
