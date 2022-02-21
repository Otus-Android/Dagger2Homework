package ru.otus.daggerhomework.di
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelFactory
import javax.inject.Named

@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject (fragmentProducer: FragmentProducer)

    @Subcomponent.Factory
    interface Factory{
        fun create ():FragmentProducerComponent
    }

}

@Module
class FragmentProducerModule {

    @Provides
    fun providesViewModelProducer(
        colorGenerator: ColorGenerator,
        @Named("MainActivityContext") context: Context,
        mutableStateFlow: MutableStateFlow<Int>
    ):ViewModelFactory{
        return ViewModelFactory(colorGenerator,context,mutableStateFlow)
    }
}

