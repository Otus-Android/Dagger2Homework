package com.mironchik.multimodule.features.producer_impl

import com.mironchik.multimodule.base.colors.ColorsController
import com.mironchik.multimodule.base.colors.ColorsControllerProvider
import com.mironchik.multimodule.base.colors.ColorsGenerator
import com.mironchik.multimodule.core.api.AggregatingProvider
import com.mironchik.multimodule.core.api.scopes.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [AggregatingProvider::class, ColorsControllerProvider::class],
)
interface FragmentProducerComponent {
    @Component.Factory
    interface Factory {
        fun create(
            aggregatingProvider: AggregatingProvider,
            colorsControllerProvider: ColorsControllerProvider,
            @BindsInstance colorGenerator: ColorsGenerator,
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}