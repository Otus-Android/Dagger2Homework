package ru.otus.daggerhomework.di.receiver

import dagger.Component
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.di.main.MainActivityComponent
import ru.otus.daggerhomework.di.producer.FragmentProducerComponent
import ru.otus.daggerhomework.reciever.FragmentReceiver

@FragmentScope
@Component(
    modules = [ReceiverViewModelModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {

        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(target: FragmentReceiver)
}