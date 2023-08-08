package ru.otus.daggerhomework.di.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import ru.otus.daggerhomework.di.producer.FragmentProducerComponent
import ru.otus.daggerhomework.di.receiver.FragmentReceiverComponent
import ru.otus.daggerhomework.di.utils.qualifiers.ActivityContext
import ru.otus.daggerhomework.di.utils.scopes.ActivityScope

/**
 * `Dagger` [Component] главного экрана
 */
@ActivityScope
@Subcomponent(modules = [MainActivityModule::class, MainActivitySubcomponentsModule::class])
interface MainActivityComponent {

    /** Фабрика `Dagger` [Component]-а Fragment`-а поставления цветов */
    val fragmentProducerComponentFactory: FragmentProducerComponent.Factory

    /** Фабрика `Dagger` [Component]-а Fragment`-а получения цветов */
    val fragmentReceiverComponentFactory: FragmentReceiverComponent.Factory

    /** Фабрика `Dagger` [Component]-а главного экрана */
    @Subcomponent.Factory
    interface Factory {

        /** Создать [MainActivityComponent] на основе контекста `Activity` [context] */
        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }
}