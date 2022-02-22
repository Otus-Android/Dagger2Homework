package ru.otus.daggerhomework
import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.Activity
import ru.otus.daggerhomework.Application
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.MainActivityComponent
import java.lang.ref.WeakReference

@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {
    val viewModelReceiver: ViewModelReceiver
}
@Module
interface FragmentReceiverModule {
    @Binds
    fun provideStateFlow(stateFlow: MutableStateFlow<Int>): StateFlow<Int>
}