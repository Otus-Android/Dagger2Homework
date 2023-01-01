package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.components.FragmentProducerComponent
import ru.otus.daggerhomework.components.FragmentReceiverComponent
import ru.otus.daggerhomework.components.MainActivityComponent
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl

@Module(subcomponents = [MainActivityComponent::class])
class AppSubcomponentsModule

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
class MainActivitySubcomponentsModule

@Module
interface AppModule {

    @AppScope
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}
