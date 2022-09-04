package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@ReceiverScope
@Component(
    modules = [ReceiverModule::class],
    dependencies = [MainActivityComponent::class],
)
interface ReceiverComponent {

    companion object {
        fun getReceiverComponent(mainActivityComponent: MainActivityComponent): ReceiverComponent {
            return DaggerReceiverComponent.factory().create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): ReceiverComponent
    }

    fun inject(receiverFragment: FragmentReceiver)

}

@Module
interface ReceiverModule {

    @Binds
    fun bindViewModelFactory(viewModelReceiverFactory: ViewModelReceiverProviderFactory): ViewModelProvider.Factory

    companion object {
        @Provides
        fun provideViewModelReceiver(factory: ViewModelProvider.Factory) = factory.create(ViewModelReceiver::class.java)
    }

}

@Scope
annotation class ReceiverScope