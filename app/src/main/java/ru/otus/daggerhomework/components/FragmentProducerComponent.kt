package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}
