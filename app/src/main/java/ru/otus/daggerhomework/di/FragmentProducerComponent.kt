package ru.otus.daggerhomework.di

import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.Component
import dagger.Provides
import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentProducerComponent
    }

/*
    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentProducerComponent
    }*/

    fun inject(fragment: FragmentProducer)


}