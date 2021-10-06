package ru.otus.daggerhomework.components

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.Events
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Named

@Module
class ViewModelModule {

    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    @Provides
    fun provideViewModelProducer(
        colorGenerator: ColorGenerator,
        @Named(ACTIVITY_CONTEXT) context: Context,
        stateFlow: MutableStateFlow<Events>
    ): ViewModel {
        return ViewModelProducer(colorGenerator, context, stateFlow)
    }

    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    @Provides
    fun provideViewModelReceiver(
        @Named(APPLICATION_CONTEXT) appContext: Context,
        stateFlow: MutableStateFlow<Events>
    ): ViewModel {
        return ViewModelReceiver(appContext, stateFlow)
    }

}