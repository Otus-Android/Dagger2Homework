package ru.otus.daggerhomework.di


import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl


@Module(subcomponents = [MainActivityComponent::class])
class ApplicationModule{

    @ApplicationScope
    @Provides
    fun provideColorEvent(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }

    @Provides
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator{
        return colorGeneratorImpl
    }
}