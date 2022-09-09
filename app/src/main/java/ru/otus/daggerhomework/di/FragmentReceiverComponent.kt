package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.viewModel.ViewModelKey
import ru.otus.daggerhomework.viewModel.ViewModelProducer
import ru.otus.daggerhomework.viewModel.ViewModelReceiver

@Subcomponent
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }

}

@Module
interface ReceiverFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun bindsProducerViewModel(viewModel: ViewModelReceiver): ViewModel
}