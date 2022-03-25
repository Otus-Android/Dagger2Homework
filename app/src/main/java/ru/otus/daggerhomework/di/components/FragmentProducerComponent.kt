package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.modules.viewModels.ViewModelModuleFragmentProducer
import ru.otus.daggerhomework.views.FragmentProducer
import javax.inject.Scope
@FragmentScope
@Component(modules = [ViewModelModuleFragmentProducer::class], dependencies = [ActivityComponent::class])
interface FragmentProducerComponent {
    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentProducerComponent
    }
    fun inject(fragment: FragmentProducer)
}
@Scope
annotation class FragmentScope