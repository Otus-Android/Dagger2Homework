package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.di.annotations.AppContext

@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        @AppContext
        fun applicationContext(context: Context): Builder

        fun build(): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)

}