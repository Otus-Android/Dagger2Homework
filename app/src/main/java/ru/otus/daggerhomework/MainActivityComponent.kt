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

            @BindsInstance dataFlow: MutableSharedFlow<Int>,
            @BindsInstance colorReceiver: ColorReceiver,
            @BindsInstance colorProducer: ColorProducer
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context


    fun provideDataFlow(): MutableSharedFlow<Int>

    fun provideColorReceiver(): ColorReceiver

    fun provideColorProducer(): ColorProducer
}