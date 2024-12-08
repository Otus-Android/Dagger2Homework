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


@Component(
    modules = [
        ColorPipelineModule::class,
        ColorGeneratorModule::class,
    ]
)
@AppScope
interface ApplicationComponent {
    companion object {
        fun getInstance(@ApplicationContext context: Context): ApplicationComponent =
            DaggerApplicationComponent.factory()
                .create(context)
    }

    @ApplicationContext
    fun application(): Context

    fun colorGenerator(): ColorGenerator

    @Publisher
    @JvmSuppressWildcards
    fun publisher(): FlowCollector<ColorNumber>

    @Subscriber
    fun subscriber(): Flow<ColorNumber>

    @Component.Factory
    interface ApplicationComponentBuilder {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Qualifier
annotation class ApplicationContext

@Scope
annotation class AppScope