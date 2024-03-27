package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator

@Component(
    dependencies = [MainActivityComponent::class],
)
@PerFragment
interface FragmentProducerComponent {

    @ActivityContext
    fun provideContext(): Context

    fun provideObserver(): MutableStateFlow<Int>

    fun provideColorGenerator(): ColorGenerator

    companion object {

        fun build(mainActivityComponent: MainActivityComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
        }
    }

}