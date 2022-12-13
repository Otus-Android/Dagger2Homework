package ru.otus.daggerhomework.receiver

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.applicaion.ViewModelApi
import ru.otus.daggerhomework.applicaion.ViewModelKey
import javax.inject.Scope

@Subcomponent(modules = [ReceiverModule::class])
@ReceiverScope
interface FragmentReceiverComponent : ViewModelApi

@Scope
@Retention
annotation class ReceiverScope

@Module
internal interface ReceiverModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun viewModelReceiver(viewModelReceiver: ViewModelReceiver): ViewModel

}