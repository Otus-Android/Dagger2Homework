package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class ActivityScope

@Module
interface MainActivityModule {

    @ActivityScope
    @Binds
    fun bindsMediator(mediator: MediatorImpl): Mediator

    @ActivityScope
    @Binds
    fun bindsColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@ActivityScope
@Component(
    modules = [
        MainActivityModule::class
    ],
    dependencies = [
        ApplicationComponent::class
    ]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("ActivityContext")context: Context, component: ApplicationComponent): MainActivityComponent
    }

    fun getMediator(): Mediator

    fun getColorGenerator(): ColorGenerator

    @Named("AppContext")
    fun getAppContext(): Context

    @Named("ActivityContext")
    fun getActivityContext(): Context
}
