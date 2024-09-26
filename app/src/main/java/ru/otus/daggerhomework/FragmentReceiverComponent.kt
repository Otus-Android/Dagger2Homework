package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface FragmentReceiverComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)

    fun getViewModelReceiverFactory(): ViewModelReceiver.Factory
}