package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.modules.viewModels.ViewModelModuleFragmentReceiver
import ru.otus.daggerhomework.views.FragmentReceiver
import javax.inject.Scope
@FragmentScope
@Component(modules = [ViewModelModuleFragmentReceiver::class], dependencies = [ActivityComponent::class])
interface FragmentReceiverComponent {
    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentReceiverComponent
    }
    fun inject(fragment: FragmentReceiver)
}
