package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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