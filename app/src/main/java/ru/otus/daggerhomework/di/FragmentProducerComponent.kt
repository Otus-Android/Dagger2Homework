package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import javax.inject.Scope

@FeaturedScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @ActivityContext
    fun context():Context

    @Component.Factory
    interface Factory{
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}

@Scope
annotation class FeaturedScope