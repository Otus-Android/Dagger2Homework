package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ProducerFragment
import ru.otus.daggerhomework.StateContainer
import ru.otus.daggerhomework.StateContainerImpl
import javax.inject.Singleton

@FragmentScope
@Component(
    modules = [ProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface ProducerFragmentComponent {
    fun inject(producerFragment: ProducerFragment)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): ProducerFragmentComponent
    }

}

@Module
interface ProducerModule {
    @Binds
    fun bindsColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}