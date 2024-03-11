package ru.otus.daggerhomework

import android.content.Context
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Component(
    dependencies = [MainActivityComponent::class],
)
@FragmentScope
interface FragmentProducerComponent {

    @ActivityContext
    fun provideContext(): Context

    fun provideObserver(): MutableStateFlow<Int>

    fun provideColorGenerator(): ColorGenerator

    companion object {

        fun get(mainActivityComponent: MainActivityComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
        }

    }

}