package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Component
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import javax.inject.Named

@Subcomponent(
//    dependencies = [MainActivityComponent::class],
    modules = [ViewModelsModule::class, ToolsModule::class]
)
interface FragmentProducerComponent {

    @Subcomponent.Builder
    interface Builder {
        fun create (): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)

//    @Named("ActivityContext")
//    fun provideContext(): Context

}