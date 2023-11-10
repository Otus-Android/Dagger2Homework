package ru.otus.daggerhomework

import android.content.Context
import dagger.Component
import javax.inject.Scope

@FeaturedScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)
    @MainActivityContext
    fun context():Context

    @Component.Factory
    interface Factory{
        fun create(mainActivityComponent: MainActivityComponent):FragmentProducerComponent
    }
}

@Scope
annotation class FeaturedScope
