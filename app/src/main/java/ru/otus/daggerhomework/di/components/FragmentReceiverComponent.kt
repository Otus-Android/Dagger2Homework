package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.annotations.AppContext

@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        @AppContext
        fun applicationContext(context: Context): Builder

        fun build(): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)

}