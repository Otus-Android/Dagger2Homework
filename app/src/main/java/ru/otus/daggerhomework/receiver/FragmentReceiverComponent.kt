package ru.otus.daggerhomework.receiver

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.ActivityContext
import ru.otus.daggerhomework.MainActivityComponent

@Component(
    modules = [ReceiverModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @ActivityContext
    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }
}