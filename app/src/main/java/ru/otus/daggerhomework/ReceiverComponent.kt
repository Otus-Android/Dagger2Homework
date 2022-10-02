package ru.otus.daggerhomework

import dagger.Component
import dagger.Module
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
}

@Scope
annotation class ReceiverScope