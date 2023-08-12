package ru.otus.daggerhomework.feature.di

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.activity.MainActivity
import ru.otus.daggerhomework.feature.fragments.ReceiverFragment
import ru.otus.daggerhomework.feature.providers.ColorProvider
import ru.otus.daggerhomework.scope.FeatureScope

@FeatureScope
@Component(
    dependencies = [ApplicationComponent::class, ColorProvider::class],
    modules = [ReceiverFragmentModule::class]
)
interface ReceiverFragmentComponent {
    fun inject(receiverFragment: ReceiverFragment)

    companion object {
        fun create(app: App, activity: MainActivity) : ReceiverFragmentComponent =
            DaggerReceiverFragmentComponent.builder()
                .applicationComponent(app.getAppComponent())
                .colorProvider(activity.getActivityComponent())
                .build()
    }
}