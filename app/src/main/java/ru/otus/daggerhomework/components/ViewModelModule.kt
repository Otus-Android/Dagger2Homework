package ru.otus.daggerhomework.components

import android.app.Application
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

@Module
class ViewModelModule {

    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    @Provides
    fun provideViewModelProducer(colorGenerator: ColorGenerator, activity: FragmentActivity, stateFlow: MutableStateFlow<Events>): ViewModel {
        return ViewModelProducer(colorGenerator, activity, stateFlow)
    }

    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    @Provides
    fun provideViewModelReceiver(
        application: Application,
        stateFlow: MutableStateFlow<Events>
    ): ViewModel {
        return ViewModelReceiver(application, stateFlow)
    }

}