package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableSharedFlow


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

    fun provideColorReceiver(): ColorReceiver

    fun provideColorProducer(): ColorProducer
}