package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component


@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext activityContext: Context,
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorReceiver(): ColorReceiver

    fun provideColorProducer(): ColorProducer
}