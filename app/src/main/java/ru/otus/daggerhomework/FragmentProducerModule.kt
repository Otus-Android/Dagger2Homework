package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelProducer

@Module
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    companion object {

        @Provides
        fun provideViewModelProducer(
            @ActivityContext context: Context,
            colorStateFlow: MutableStateFlow<Int?>,
            colorGenerator: ColorGenerator
        ): ViewModelProducer {
            return ViewModelProducer(context, colorStateFlow, colorGenerator)
        }
    }
}