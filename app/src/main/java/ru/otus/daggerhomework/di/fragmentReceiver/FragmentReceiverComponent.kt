package ru.otus.daggerhomework.di.fragmentReceiver

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.activityMain.MainActivityComponent
import ru.otus.daggerhomework.di.annotation.scope.FragmentReceiverScope

@FragmentReceiverScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
}
