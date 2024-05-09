package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {
    companion object {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent =
            DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
    }

    fun inject(fragment: FragmentReceiver)

}

@Module
interface FragmentReceiverModule {
    @Binds
    fun provideViewModel(viewModelReceiverFactory: ViewModelReceiverFactory): ViewModelProvider.Factory
}