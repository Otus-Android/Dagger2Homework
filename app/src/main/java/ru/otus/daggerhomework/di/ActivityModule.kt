package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

/**
 * @author o.s.terekhova
 */
@Module
class ActivityModule {

    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()

    @Provides
    @ActivityScope
    fun provideColorMutableStateFlow(): StateFlow<Int> = MutableStateFlow(0)
}
