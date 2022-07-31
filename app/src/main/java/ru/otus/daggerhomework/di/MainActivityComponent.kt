package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named
import javax.inject.Scope

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, ViewModelModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory
    fun fragmentProducerComponent(): FragmentProducerComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @Named("ActivityContext") context: Context): MainActivityComponent
    }
}

@Scope
annotation class ActivityScope