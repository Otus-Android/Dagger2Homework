package ru.otus.daggerhomework.di

import com.mironchik.multimodule.base.colors.ColorsController
import com.mironchik.multimodule.base.colors.ColorsControllerProvider
import com.mironchik.multimodule.core.api.AggregatingProvider
import com.mironchik.multimodule.core.api.scopes.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@FeatureScope
@Component(
    dependencies = [AggregatingProvider::class, ColorsControllerProvider::class]
)
interface FragmentReceiverComponent {
    @Component.Factory
    interface Factory {
        fun create(
            aggregatingProvider: AggregatingProvider,
            colorsControllerProvider: ColorsControllerProvider,
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}