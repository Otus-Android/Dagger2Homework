package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.modules.viewModels.ViewModelModuleFragmentReceiver
import ru.otus.daggerhomework.views.FragmentReceiver
import javax.inject.Scope
@FragmentReceiverComponentScope
@Component(modules = [ViewModelModuleFragmentReceiver::class], dependencies = [AppComponent::class, ActivityComponent::class])
interface FragmentReceiverComponent {
    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent, activityComponent: ActivityComponent): FragmentReceiverComponent
    }
    fun inject(fragment: FragmentReceiver)
}
@Scope
annotation class FragmentReceiverComponentScope
