package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent(modules = [MainActivityAggregatingModule::class, MainActivityModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance  context: Context
        ): MainActivityComponent
    }

    fun addFragmentProducerComponent(): FragmentProducerComponent.Factory

    fun addFragmentReceiverComponent(): FragmentReceiverComponent.Factory
}

@Module(subcomponents = [
    FragmentProducerComponent::class,
    FragmentReceiverComponent::class]
)
interface MainActivityAggregatingModule

@Module
interface MainActivityModule {

    @Binds
    fun bindsColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}