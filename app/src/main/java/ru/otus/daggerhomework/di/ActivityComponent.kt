package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
annotation class ActivityScope

@Subcomponent(modules = [ColorModule::class])
@ActivityScope
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            activityContext: Context
        ): ActivityComponent
    }

    val fragmentProducerComponent: FragmentProducerComponent

    val fragmentReceiverComponent: FragmentReceiverComponent
}

@Module
interface ColorModule {

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

    @Binds
    @ActivityScope
    fun bindColorObserver(impl: ColorObserverImpl): ColorObserver
}

@Qualifier
annotation class ActivityContext