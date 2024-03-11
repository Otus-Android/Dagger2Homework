package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
object ColorGeneratorModule {

    @Provides
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }

}