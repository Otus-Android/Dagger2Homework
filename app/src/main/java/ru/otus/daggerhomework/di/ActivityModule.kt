package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface ActivityModule {

    companion object {
        @ActivityScope
        @Provides
        fun provideMutableStateFlow(): MutableStateFlow<Int> = MutableStateFlow(-1)

        @Provides
        fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()

    }

    @ActivityScope
    @Binds
    fun provideStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>

}