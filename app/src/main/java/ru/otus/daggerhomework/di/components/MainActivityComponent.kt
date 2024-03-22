package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.annotations.ActivityContext
import ru.otus.daggerhomework.di.annotations.AppContext
import ru.otus.daggerhomework.di.annotations.MainActivityScope
import ru.otus.daggerhomework.di.modules.MainActivityModule

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun fragmentProducerComponentBuilder(): FragmentProducerComponent.Builder
    fun fragmentReceiverComponentBuilder(): FragmentReceiverComponent.Builder

    fun getColorState(): StateFlow<Int>

    @AppContext
    fun context(): Context

    @ActivityContext
    fun contextActivity(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext context: Context, applicationComponent: ApplicationComponent): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

}