package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Scope

@Component(
    dependencies = [MainActivityComponent::class],
)
@PerFragment
interface FragmentReceiverComponent {

    @AppContext
    fun provideContext(): Context

    fun provideObserver(): MutableStateFlow<Int>

    companion object {
        fun build(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
        }
    }
}

@Scope
annotation class PerFragment