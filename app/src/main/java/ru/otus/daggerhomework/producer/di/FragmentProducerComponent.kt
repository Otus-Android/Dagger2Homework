package ru.otus.daggerhomework.producer.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.common.FragmentScope
import ru.otus.daggerhomework.common.NeedInitializeException
import ru.otus.daggerhomework.common.ViewModelProviderFactory
import ru.otus.daggerhomework.main.di.MainActivityComponent
import ru.otus.daggerhomework.receiver.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.receiver.di.FragmentReceiverComponent
import ru.otus.daggerhomework.receiver.di.ReceiverDependency
import javax.inject.Named

@Component(
    modules = [ProducerBindings::class],
    dependencies = [ProducerDependency::class]
)
@FragmentScope
interface FragmentProducerComponent {

    val viewModelProviderFactory: ViewModelProviderFactory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named(APPLICATION_CONTEXT_QUALIFIER) applicationContext: Context,
            @BindsInstance @Named(ACTIVITY_CONTEXT_QUALIFIER) context: Context,
            dependency: ProducerDependency
        ): FragmentProducerComponent
    }

    companion object {
        const val APPLICATION_CONTEXT_QUALIFIER = "applicationContext"
        const val ACTIVITY_CONTEXT_QUALIFIER = "activityContext"

        private var mComponent: FragmentProducerComponent? = null

        fun init(mainActivityComponent: MainActivityComponent) {
            mComponent = DaggerFragmentProducerComponent.factory().create(
                applicationContext = mainActivityComponent.provideApplicationContext(),
                context = mainActivityComponent.provideActivityContext(),
                dependency = object : ProducerDependency {
                    override fun provideEventObservable() = mainActivityComponent.eventObservable
                }
            )
        }

        fun getInstance() = mComponent ?: throw NeedInitializeException()

        fun release() {
            mComponent = null
        }

    }
}