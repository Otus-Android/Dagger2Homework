package ru.otus.daggerhomework.di.receiver

import dagger.Component
import ru.otus.daggerhomework.di.main.MainActivityComponent
import ru.otus.daggerhomework.di.utils.scopes.FragmentScope
import ru.otus.daggerhomework.presentation.receiver.FragmentReceiver

/**
 * `Dagger` [Component] `Fragment`-а получения цветов
 */
@FragmentScope
@Component(modules = [FragmentReceiverModule::class], dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    /** Внедрить зависимости [FragmentReceiver]-а */
    fun inject(receiver: FragmentReceiver)

    companion object {

        /** Создать `Dagger` [Component] `Fragment`-а получения цветов на основе [MainActivityComponent] */
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent =
            DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
    }
}