package ru.otus.daggerhomework

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentReceiverModule::class],
)
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)
}

@Module
object FragmentReceiverModule {

    @FragmentScope
    @Provides
    fun provideViewModel(
        colorFlow: MutableStateFlow<Int?>,
        @AppContext context: Context,
    ): ViewModelReceiver = ViewModelReceiver(context, colorFlow)
}