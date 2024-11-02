package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [FragmentProducerModule::class],
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
    fun producerComponent(): FragmentProducerComponent.Factory
    fun receiverComponent(): FragmentReceiverComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @ActivityContext
            @BindsInstance
            context: Context,
        ): MainActivityComponent
    }
}