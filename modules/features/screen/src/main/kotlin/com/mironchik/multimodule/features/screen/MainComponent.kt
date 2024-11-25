package com.mironchik.multimodule.features.screen

import com.mironchik.multimodule.base.colors.ColorsController
import com.mironchik.multimodule.base.colors.ColorsControllerImpl
import com.mironchik.multimodule.core.api.AggregatingProvider
import com.mironchik.multimodule.features.producer_api.ProducerMediator
import com.mironchik.multimodule.features.receiver_api.ReceiverMediator
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Scope

@Scope
annotation class ActivityScope

@ActivityScope
@Component(
    dependencies = [AggregatingProvider::class],
    modules = [MainModule::class],
)
interface MainComponent {
    @Component.Factory
    interface Factory {
        fun create(
            aggregatingProvider: AggregatingProvider,
        ): MainComponent
    }

    fun inject(activity: MainActivity)
}

@Module
interface MainModule {
    companion object {
        @Provides
        @ActivityScope
        fun provideColorsController(): ColorsController {
            return ColorsControllerImpl()
        }

        @Provides
        fun provideReceiverMediator(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): ReceiverMediator {
            return map[ReceiverMediator::class.java]?.get() as ReceiverMediator
        }

        @Provides
        fun provideProducerMediator(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): ProducerMediator {
            return map[ProducerMediator::class.java]?.get() as ProducerMediator
        }
    }
}

