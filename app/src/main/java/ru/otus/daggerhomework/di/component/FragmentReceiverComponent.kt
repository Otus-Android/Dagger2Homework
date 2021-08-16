package ru.otus.daggerhomework.di.component

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.di.scope.FragmentScope
import javax.inject.Qualifier

@FragmentScope
@Component(modules = [FragmentReceiverModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, @BindsInstance context: Context): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)

    fun mainActivityComponent(mainActivityComponent: MainActivityComponent)
}

@Module
interface FragmentReceiverModule {

    companion object {
        @FragmentScope
        @ReceiverViewModel
        @Provides
        fun provideViewModelReceiver(context: Context, mutableSharedFlow: MutableSharedFlow<Int>): ViewModelReceiver {
            return ViewModelReceiver(context, mutableSharedFlow)
        }
    }

    @FragmentScope
    @ReceiverViewModel
    @Binds
    fun bindReceiverViewModelFactory(receiverViewModelFactory: ViewModelReceiver.ReceiverViewModelFactory): ViewModelProvider.Factory
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReceiverViewModel