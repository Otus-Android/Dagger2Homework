package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ApplicationComponent

@Component(
    dependencies = [ApplicationComponent::class],
)
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun create(app: App) : FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .applicationComponent(app.getAppComponent())
                .build()
        }
    }
}