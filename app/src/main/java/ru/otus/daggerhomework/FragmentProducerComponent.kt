package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@FragmentScope
@Component(dependencies = [MainActivityComponent::class],
modules = [ProducerModule::class])
interface FragmentProducerComponent {

    companion object {
        fun crete(
              activityComponent: MainActivityComponent
        ) = DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()

    }
    fun inject(fragment: FragmentProducer)

}

@Module
interface ProducerModule {

    @Binds
    @FragmentScope
    fun bindColorGenerator(generator: ColorGeneratorImpl): ColorGenerator
}