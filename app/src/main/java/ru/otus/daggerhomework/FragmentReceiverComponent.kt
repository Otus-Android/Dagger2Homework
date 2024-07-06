package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}

@Module
interface FragmentReceiverModule {

    @Binds
    @Named("ReceiverFactory")
    fun bindsViewModelReceiverFactory(
        viewModelReceiverFactory: ViewModelReceiverFactory
    ): ViewModelProvider.Factory

}