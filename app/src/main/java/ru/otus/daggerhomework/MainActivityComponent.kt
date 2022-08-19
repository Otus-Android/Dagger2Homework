package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityAbstractModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun fragmentProducerComponentFactory(): FragmentProducerComponent.Factory

    fun fragmentReceiverComponentFactory(): FragmentReceiverComponent.Factory
}

@Module
interface MainActivityAbstractModule {

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun bindColorObserver(impl: ColorObserver.Base): ColorObserver
}