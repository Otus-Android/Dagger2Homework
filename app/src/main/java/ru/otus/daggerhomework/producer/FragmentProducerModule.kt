package ru.otus.daggerhomework.producer

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.activity.Event
import ru.otus.daggerhomework.qualifier.ActivityContext

@Module
interface FragmentProducerModule {

    @Binds
    fun createColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    companion object {

        @Provides
        fun createProducerViewModel(
            @ActivityContext context: Context,
            colorGenerator: ColorGenerator,
            eventUpdater: MutableStateFlow<Event?>
        ) = ViewModelProducer(context, colorGenerator, eventUpdater)
    }
}