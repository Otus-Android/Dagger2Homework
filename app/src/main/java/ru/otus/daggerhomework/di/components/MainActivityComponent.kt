package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorProducer
import ru.otus.daggerhomework.ColorReceiver
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.di.PerActivity
import ru.otus.daggerhomework.di.module.ColorObserverModule

@Component(
    modules = [ColorObserverModule::class],
    dependencies = [ApplicationComponent::class]
)
@PerActivity
interface MainActivityComponent {

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorProducer(): ColorProducer
    fun provideColorReceiver(): ColorReceiver

    companion object {
        fun createComponent(
            @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent {
            return DaggerMainActivityComponent.factory().create(context, appComponent)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }

}