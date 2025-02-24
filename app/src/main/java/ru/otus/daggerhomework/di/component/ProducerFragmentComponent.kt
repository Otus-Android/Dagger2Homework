package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.ProducerFragment
import ru.otus.daggerhomework.ProducerViewModel
import ru.otus.daggerhomework.di.module.ColorGeneratorModule
import ru.otus.daggerhomework.di.scope.FragmentScope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ColorGeneratorModule::class]
)
interface ProducerFragmentComponent {


    @Component.Factory
    interface Factory {
        fun create(
            activityComponent: MainActivityComponent
        ): ProducerFragmentComponent
    }

    fun getProducerViewModel(): ProducerViewModel
    fun inject(producerFragment: ProducerFragment)

}