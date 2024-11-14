package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Scope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)

    companion object {
        fun getFragmentProducerComponent(mainActivityComponent: MainActivityComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(mainActivityComponent).build()
        }
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope
