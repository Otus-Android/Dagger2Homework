package ru.otus.daggerhomework.producer

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.di.ApplicationComponent

@Component (dependencies = [ApplicationComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    companion object {
        fun create(app: App): FragmentProducerComponent {
            return DaggerFragmentProducerComponent
                .builder()
                .applicationComponent(app.getAppComponent())
                .build()
        }
    }
}
