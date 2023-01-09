package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, ApplicationSubcomponents::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext context: Context): ActivityComponent
    }

    fun producerComponent(): FragmentProducerComponent.Factory

    fun receiverComponent(): FragmentReceiverComponent.Factory
}
