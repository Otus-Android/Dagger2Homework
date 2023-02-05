package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.fragments.BaseViewModel
import ru.otus.daggerhomework.fragments.producer.ViewModelProducer
import ru.otus.daggerhomework.fragments.recevier.FragmentReceiver
import ru.otus.daggerhomework.fragments.recevier.ViewModelReceiver

@FragmentScope
@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}

@Module
interface FragmentReceiverViewModel {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun bindFragmentReceiverViewModel(viewModel: ViewModelReceiver): BaseViewModel
}
