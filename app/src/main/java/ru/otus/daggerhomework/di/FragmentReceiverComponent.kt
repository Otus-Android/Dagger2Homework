package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Qualifier

@FragmentScope
@Component(modules = [FragmentReceiverModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent, @BindsInstance context: Context): FragmentReceiverComponent
    }

    companion object{
        fun create(context: Context): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.factory()
                .create(MainActivityComponent.create(context), context)
        }
    }

    fun inject(fragment: FragmentReceiver)
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