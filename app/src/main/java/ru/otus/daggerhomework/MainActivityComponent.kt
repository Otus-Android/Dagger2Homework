package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow


@Module()
object MainActivityModule {

    /** Здесь было лучше и проще использовать MutableStateFlow или хотабы с replay 0, но мне захотелось попробовать с этим, получилось не очень */
    @Provides
    @ActivityScope
    fun providerEvent(): MutableSharedFlow<AppEvent> =
        MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)
}

@Module(subcomponents = [FragmentReceiverComponent::class, FragmentProducerComponent::class])
interface MainActivitySubcomponentsModule

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class, MainActivitySubcomponentsModule::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@ActivityContext @BindsInstance activityContext: Context): MainActivityComponent
    }

    fun fragmentProducerComponent(): FragmentProducerComponent
    fun fragmentReceiverComponent(): FragmentReceiverComponent
}