package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.ProducerViewModel
import javax.inject.Named


@Module
class ProducerModule {

    @Provides
    @FragmentScope
    fun colorGenerator(): ColorGenerator = ColorGeneratorImpl()

    @Provides
    @FragmentScope
    fun viewModel(
        colorGenerator: ColorGenerator,
        context: Context,
        event: MutableStateFlow<Event?>
    ): ProducerViewModel = ProducerViewModel(colorGenerator, context, event)
}