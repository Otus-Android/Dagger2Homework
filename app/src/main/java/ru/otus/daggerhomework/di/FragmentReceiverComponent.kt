package ru.otus.daggerhomework.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.Observer
import ru.otus.daggerhomework.ViewModelReceiver

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface FragmentReceiverComponentFactory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}

@Module
class FragmentReceiverModule {
    @FragmentScope
    @Provides
    fun provideViewModel(application: Application, observer: Observer) : ViewModelReceiver {
        return ViewModelReceiver(application, observer)
    }
}