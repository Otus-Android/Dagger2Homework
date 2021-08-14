package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.module.FragmentProducerModule
import ru.otus.daggerhomework.di.scope.FragmentScope

@FragmentScope
@Component(modules = [FragmentProducerModule::class/*, FragmentProducerModuleFlow::class*/], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, @BindsInstance context: Context): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}