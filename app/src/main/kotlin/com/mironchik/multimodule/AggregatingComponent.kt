package com.mironchik.multimodule

import com.mironchik.multimodule.core.api.AggregatingProvider
import com.mironchik.multimodule.core.api.CoreProvider
import com.mironchik.multimodule.features.producer_impl.ProducerModuleExternal
import com.mironchik.multimodule.features.receiver_impl.ReceiverModuleExternal
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreProvider::class],
    modules = [ProducerModuleExternal::class, ReceiverModuleExternal::class]
)
interface AggregatingComponent : AggregatingProvider {
    @Component.Factory
    interface Factory {
        fun create(rootProvider: CoreProvider): AggregatingComponent
    }
}