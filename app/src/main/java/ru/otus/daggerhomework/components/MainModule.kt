package ru.otus.daggerhomework.components

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.Events

@Module
interface MainModule {

    companion object {
        @Provides
        @MainScope
        fun provideStateFlow(): MutableStateFlow<Events> {
            return MutableStateFlow(Events.Empty)
        }

        @Provides
        fun provideColorGenerator(): ColorGenerator {
            return ColorGeneratorImpl()
        }
    }
}