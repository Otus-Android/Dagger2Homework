package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiverFactory

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {

    companion object {
        fun getFragmentReceiverComponent(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent =
            DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
interface FragmentReceiverModule {
    @Binds
    fun bindFactory(viewModelReceiverFactory: ViewModelReceiverFactory): ViewModelProvider.Factory

}