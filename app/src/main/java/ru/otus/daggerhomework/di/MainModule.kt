package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl


@Module(includes = [MainBindModule::class])
abstract class MainModule {

    companion object {
        @Provides
        @ActivityScope
        fun provideMutableStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }


}


@Module
interface MainBindModule{

    @Binds
    fun bindStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}