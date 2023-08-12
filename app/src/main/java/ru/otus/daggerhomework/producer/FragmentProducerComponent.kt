package ru.otus.daggerhomework.producer

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.activity.MainActivity

@Component(
    dependencies = [ApplicationComponent::class, EventUpdateProvider::class, ActivityContextProvider::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    companion object {
        fun create(app: App, activity: MainActivity): FragmentProducerComponent {
            val activityComponent = activity.getActivityComponent()
            return DaggerFragmentProducerComponent.builder()
                .applicationComponent(app.getAppComponent())
                .eventUpdateProvider(activityComponent)
                .activityContextProvider(activityComponent)
                .build()
        }
    }
}