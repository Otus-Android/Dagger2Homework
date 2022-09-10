package ru.otus.daggerhomework.producer.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.activity.di.ColorState

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    companion object {
        @Provides
        @ProducerColorState
        fun bindColorMutableStateFlow(@ColorState stateFlow: StateFlow<Int?>): MutableStateFlow<Int?> {
            return stateFlow as MutableStateFlow<Int?>
        }
    }
}