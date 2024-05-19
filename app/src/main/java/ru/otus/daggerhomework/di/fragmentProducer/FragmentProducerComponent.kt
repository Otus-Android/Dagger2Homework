package ru.otus.daggerhomework.di.fragmentProducer

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.activityMain.MainActivityComponent
import ru.otus.daggerhomework.di.annotation.scope.FragmentProducerScope

@FragmentProducerScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)
}
