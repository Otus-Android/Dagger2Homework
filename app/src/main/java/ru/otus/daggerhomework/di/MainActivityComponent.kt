package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Subcomponent
interface MainActivityComponent {

    fun createProducerComponent(): FragmentProducerComponent
    fun createReceiverComponent(): FragmentReceiverComponent

    @Subcomponent.Factory
    interface  MainActivityComponentFactory {

        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }
}

@Qualifier
@Singleton
annotation class ActivityContext