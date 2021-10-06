package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver
import javax.inject.Named

const val ACTIVITY_CONTEXT = "activityContext"

@MainScope
@Component(modules = [MainModule::class, ViewModelModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun getFragmentReceiverComponent() : FragmentReceiverComponent
    fun getFragmentProducerComponent() : FragmentProducerComponent

    @Named(ACTIVITY_CONTEXT)
    fun getActivityContext() : Context

    @Component.Factory
    interface MainCompFactory {
        fun create(
            applicationComponent: ApplicationComponent,
            @Named(ACTIVITY_CONTEXT) @BindsInstance activityContext: Context
        ): MainActivityComponent
    }
}