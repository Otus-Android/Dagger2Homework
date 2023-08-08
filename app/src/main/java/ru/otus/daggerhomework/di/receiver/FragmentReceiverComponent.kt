package ru.otus.daggerhomework.di.receiver

import dagger.Component
import dagger.Subcomponent
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver

/**
 * `Dagger` [Component] `Fragment`-а получения цветов
 */
@FragmentScope
@Subcomponent(modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    /** Внедрить зависимости [FragmentReceiver]-а */
    fun inject(receiver: FragmentReceiver)

    /** Фабрика `Dagger` [Component]-а Fragment`-а получения цветов */
    @Subcomponent.Factory
    interface Factory {

        /** Создать [FragmentReceiverComponent] */
        fun create(): FragmentReceiverComponent
    }
}