package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ProducerFragment

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class],
)
interface ProducerFragmentComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): ProducerFragmentComponent
    }

    fun inject(fragment: ProducerFragment)
}