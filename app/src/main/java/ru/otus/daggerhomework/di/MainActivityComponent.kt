package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.annotations.ActivityContext
import ru.otus.daggerhomework.di.annotations.ActivityScope

@ActivityScope
@Subcomponent(
    modules = [FragmentProducerModule::class, FragmentReceiverModule::class],
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