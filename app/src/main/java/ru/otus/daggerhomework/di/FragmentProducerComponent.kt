package ru.otus.daggerhomework.di

import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.Component
import dagger.Provides
import dagger.Subcomponent

@Subcomponent
interface FragmentProducerComponent {

    fun producer(): MutableLiveData<Int>
/*
    @Component.Factory
    interface Factory{
        fun create(): FragmentProducerComponent
    }
*/


}