package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.EventObserver
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.FeatureScope
import ru.otus.daggerhomework.di.module.ProducerModule

@FeatureScope
@Component(
    modules = [ProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface ProducerComponent {
    companion object {
        fun getProducerComponent(component: MainActivityComponent): ProducerComponent {
            return DaggerProducerComponent.builder().mainActivityComponent(component).build()
        }
    }

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideEventObserver(): EventObserver

    fun inject(fragmentProducer: FragmentProducer)
}