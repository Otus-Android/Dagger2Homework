package ru.otus.daggerhomework.di.activity

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import ru.otus.daggerhomework.ColorEvent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.fragment.FragmentProducerComponent
import ru.otus.daggerhomework.di.fragment.FragmentReceiverComponent
import ru.otus.daggerhomework.di.scopes.ActivityScope


@Module(
    subcomponents = [
        FragmentReceiverComponent::class,
        FragmentProducerComponent::class
    ]
)
interface MainActivityModule {

    companion object {

        @Provides
        @ActivityScope
        fun provideColorEvent(): MutableSharedFlow<ColorEvent> {
            return MutableSharedFlow<ColorEvent>(
                replay = 1,
                onBufferOverflow = BufferOverflow.DROP_OLDEST
            ).apply {
                distinctUntilChanged()
            }
        }
    }

    @Binds
    @Reusable
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}