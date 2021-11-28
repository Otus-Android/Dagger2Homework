package ru.otus.daggerhomework

import android.app.Activity
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.producer.FragmentProducerComponent
import ru.otus.daggerhomework.producer.FragmentReceiverComponent

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance contextActivity: Activity): MainActivityComponent
    }

    fun inject(activity: MainActivity)


    fun fragmentProducerComponent(): FragmentProducerComponent.Factory
    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory
}

@Module(subcomponents = [FragmentProducerComponent::class,FragmentReceiverComponent::class ])
class MainActivityModule{
    @Provides
    @ActivityScope
   fun producerColor(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}
