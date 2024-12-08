package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import ru.otus.daggerhomework.ColorNumber
import ru.otus.daggerhomework.ColorGenerator
import javax.inject.Qualifier
import javax.inject.Scope

@Component(dependencies = [ApplicationComponent::class])
@ActivityScope
interface MainActivityComponent {

    companion object {
        fun getInstance(appComponent: ApplicationComponent, @ActivityContext context: Context): MainActivityComponent =
            DaggerMainActivityComponent.factory()
                .create(appComponent, context)
    }

    @ActivityContext
    fun activity(): Context

    @ApplicationContext
    fun application(): Context

    fun colorGenerator(): ColorGenerator

    @Publisher
    @JvmSuppressWildcards
    fun publisher(): FlowCollector<ColorNumber>

    @Subscriber
    fun subscriber(): Flow<ColorNumber>

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context,
        ): MainActivityComponent
    }
}

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope