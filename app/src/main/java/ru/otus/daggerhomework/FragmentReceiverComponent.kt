package ru.otus.daggerhomework

import android.content.Context
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Scope
import javax.inject.Singleton

@Component(
    dependencies = [MainActivityComponent::class],
)
@FragmentScope
interface FragmentReceiverComponent {

    @ApplicationContext
    fun provideContext(): Context

    fun provideObserver(): MutableStateFlow<Int>

    companion object {

        fun get(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
        }

    }

}
