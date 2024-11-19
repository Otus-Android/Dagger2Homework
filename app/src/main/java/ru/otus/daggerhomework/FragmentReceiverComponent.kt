package ru.otus.daggerhomework

import android.app.Application
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow

@Component(
    modules = [ViewModelReceiverModule::class],
    dependencies = [ApplicationComponent::class, MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
object ViewModelReceiverModule {

    @Provides
    fun provide(context: Application, flow: MutableStateFlow<Int>): ViewModelReceiver {
        return ViewModelReceiver(context, flow)
    }
}