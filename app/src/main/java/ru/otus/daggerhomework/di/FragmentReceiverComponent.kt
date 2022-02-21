package ru.otus.daggerhomework.di


import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelFactory
import javax.inject.Named

@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    fun inject (fragmentReceiver: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory{
        fun create ():FragmentReceiverComponent
    }

}


@Module
class FragmentReceiverModule {

    @Provides
    fun providesViewModelReceiver(
        colorGenerator: ColorGenerator,
        @Named("ApplicationContext") context: Context,
        mutableStateFlow: MutableStateFlow<Int>
    ): ViewModelFactory {
        return ViewModelFactory(colorGenerator,context,mutableStateFlow)
    }
}