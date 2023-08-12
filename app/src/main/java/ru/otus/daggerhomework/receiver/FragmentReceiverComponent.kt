package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.activity.MainActivity

@Component(
    dependencies = [ApplicationComponent::class, EventProvider::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun create(app: App, activity: MainActivity) : FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .applicationComponent(app.getAppComponent())
                .eventProvider(activity.getActivityComponent())
                .build()
        }
    }
}