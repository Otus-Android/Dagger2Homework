package ru.otus.daggerhomework.feature.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.feature.models.ColorGenerator
import ru.otus.daggerhomework.feature.models.ColorGeneratorImpl
import ru.otus.daggerhomework.qualifier.ActivityContext
import ru.otus.daggerhomework.feature.viewmodels.ProducerViewModel

@Module
interface ProducerFragmentModule {

    @Binds
    fun createColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    companion object {

        @Provides
        fun createProducerViewModel(
            @ActivityContext context: Context,
            colorGenerator: ColorGenerator,
            colorUpdater: MutableStateFlow<Int?>
        ) =
            ProducerViewModel(context, colorGenerator, colorUpdater)
    }
}