package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@FragmentScope
@Component(modules = [FragmentReceiverModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent,
            @BindsInstance context: Context
        ): FragmentReceiverComponent
    }

    companion object {

        fun create(context: Context): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.factory()
                .create(MainActivityComponent.create(context), context)
        }
    }

    fun inject(fragment: FragmentReceiver)
}

@Module
interface FragmentReceiverModule {

    @FragmentScope
    @Binds
    fun bindReceiverViewModelFactory(receiverViewModelFactory: ViewModelReceiver.ReceiverViewModelFactory): ViewModelProvider.Factory
}