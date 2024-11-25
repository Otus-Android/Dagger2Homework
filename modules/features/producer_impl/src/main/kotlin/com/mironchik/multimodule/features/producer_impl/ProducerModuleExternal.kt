package com.mironchik.multimodule.features.producer_impl

import com.mironchik.multimodule.features.producer_api.ProducerMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ProducerModuleExternal {
    @Binds
    @IntoMap
    @ClassKey(ProducerMediator::class)
    fun putProducerMediator(mediatorImpl: ProducerMediatorImpl): Any
}