package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.Component
import ru.otus.daggerhomework.EventObserver
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.FeatureScope
import ru.otus.daggerhomework.di.module.ReceiverModule


@FeatureScope
@Component(
    modules = [ReceiverModule::class],
    dependencies = [MainActivityComponent::class]
)
interface ReceiverComponent {
    companion object {
        fun getReceiverComponent(component: MainActivityComponent): ReceiverComponent {
            return DaggerReceiverComponent.builder().mainActivityComponent(component).build()
        }
    }

    @ApplicationContext
    fun provideContext(): Context

    fun provideEventObserver(): EventObserver

    fun inject(fragmentReceiver: FragmentReceiver)
}

