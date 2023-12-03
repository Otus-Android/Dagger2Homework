package ru.otus.daggerhomework.di.fragments

import dagger.Component
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.presentation.FragmentReceiver

/**
 * TODO: добавить описание класса
 *
 * @author Евтушенко Максим 11.11.2023
 */
@FragmentScope
@Component(
    dependencies = [ActivityComponent::class]
)
interface FragmentReceiverComponent {
    companion object {
        fun getFragmentReceiverComponent(activityComponent: ActivityComponent): FragmentReceiverComponent =
            DaggerFragmentReceiverComponent.builder()
                .activityComponent(activityComponent)
                .build()
    }

    fun inject(fragment: FragmentReceiver)
}