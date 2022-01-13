package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.Result

@Module(subcomponents = [FragmentReceiverComponent::class, FragmentProducerComponent::class])
object MainActivityModule {
    @Provides
    @ActivityScope
    fun observer(): Channel<Result> {
        return Channel()
    }
}
