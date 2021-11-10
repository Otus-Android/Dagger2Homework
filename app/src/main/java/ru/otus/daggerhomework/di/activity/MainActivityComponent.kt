package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.fragment.FragmentProducerComponent
import ru.otus.daggerhomework.di.fragment.FragmentReceiverComponent
import ru.otus.daggerhomework.di.qualifiers.ActivityContext
import ru.otus.daggerhomework.di.scopes.ActivityScope

@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun fragmentReceiver(): FragmentReceiverComponent.Factory

    fun fragmentProducer(): FragmentProducerComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @ActivityContext
            @BindsInstance
            context: Context
        ): MainActivityComponent
    }
}