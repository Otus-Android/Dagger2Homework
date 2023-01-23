package ru.otus.daggerhomework.activity

import android.content.Context
import dagger.*
import ru.otus.daggerhomework.applicaion.ApplicationComponent
import ru.otus.daggerhomework.producer.FragmentProducerComponent
import ru.otus.daggerhomework.receiver.FragmentReceiverComponent
import javax.inject.Named
import javax.inject.Scope

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    @Component.Factory
    interface ActivityComponentFactory {
        fun create(
            @BindsInstance
            @Named("ActivityContext")
            context: Context,
            applicationComponent: ApplicationComponent
        ): ActivityComponent
    }

    fun plusProducerComponent(): FragmentProducerComponent
    fun plusReceiverComponent(): FragmentReceiverComponent
}

@Scope
annotation class MainActivityScope