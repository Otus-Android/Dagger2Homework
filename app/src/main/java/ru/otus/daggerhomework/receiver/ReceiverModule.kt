package ru.otus.daggerhomework.receiver

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelKey
import ru.otus.daggerhomework.ViewModelModule

@Module(includes = [ViewModelModule::class])
abstract class ReceiverModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    abstract fun bind(viewModel: ViewModelReceiver): ViewModel
}