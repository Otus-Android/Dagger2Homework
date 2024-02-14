package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component


@Component(
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext activityContext: Context,

            @BindsInstance colorReceiver: ColorReceiver,
            @BindsInstance colorProducer: ColorProducer
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorReceiver(): ColorReceiver

    fun provideColorProducer(): ColorProducer
}