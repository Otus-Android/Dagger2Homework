package ru.otus.daggerhomework.producer

import dagger.Component
import ru.otus.daggerhomework.ScopeFragment
import ru.otus.daggerhomework.main.MainActivityComponent

@ScopeFragment
@Component(
    modules = [ProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: MainActivityComponent
        ): FragmentProducerComponent
    }
}