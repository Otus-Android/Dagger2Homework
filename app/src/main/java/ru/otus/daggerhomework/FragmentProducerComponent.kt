package ru.otus.daggerhomework

import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(
    dependencies = [
        MainActivityComponent::class
    ],
    modules = [
        FragmentProducerModule::class
    ]
)
@FragmentScope
interface FragmentProducerComponent {
    fun providesColorProvider(): ColorProvider
    fun inject(fragmentProducer: FragmentProducer)

    companion object {
        fun inject(fragmentProducer: FragmentProducer) =
            DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(fragmentProducer.requireActivity().requireMainActivityComponent())
                .build()
                .inject(fragmentProducer)
    }
}

@Module
interface FragmentProducerModule {
    @Binds
    fun bind(@BindsInstance colorGenerator: ColorGeneratorImpl): ColorGenerator
}