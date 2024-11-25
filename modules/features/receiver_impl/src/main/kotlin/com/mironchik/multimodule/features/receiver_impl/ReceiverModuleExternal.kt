package com.mironchik.multimodule.features.receiver_impl

import com.mironchik.multimodule.features.receiver_api.ReceiverMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ReceiverModuleExternal {
    @Binds
    @IntoMap
    @ClassKey(ReceiverMediator::class)
    fun putReceiverMediator(receiverMediatorImpl: ReceiverMediatorImpl): Any
}