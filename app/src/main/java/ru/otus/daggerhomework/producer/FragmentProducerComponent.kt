package ru.otus.daggerhomework.producer

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.FragmentScope
import ru.otus.daggerhomework.MainActivityComponent
import ru.otus.daggerhomework.app.ApplicationComponent
import javax.inject.Named

@FragmentScope
@Component(
    dependencies = [
        ApplicationComponent::class,
        MainActivityComponent::class,
    ],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)
}

@Module
interface FragmentProducerModule {

    companion object {

        @Provides
        fun provideProducerViewModelFactory(
            colorGenerator: ColorGenerator,
            @Named("act") context: Context,
            eventHandler: Channel<Int>,
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {

                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    require(modelClass == ProducerViewModel::class.java)
                    return ProducerViewModel(colorGenerator, context, eventHandler) as T
                }
            }
        }
    }

    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}
