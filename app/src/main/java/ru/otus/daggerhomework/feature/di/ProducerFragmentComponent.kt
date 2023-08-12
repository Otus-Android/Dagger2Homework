package ru.otus.daggerhomework.feature.di

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.activity.MainActivity
import ru.otus.daggerhomework.feature.fragments.ProducerFragment
import ru.otus.daggerhomework.feature.providers.ActivityContextProvider
import ru.otus.daggerhomework.feature.providers.ColorUpdateProvider
import ru.otus.daggerhomework.scope.FeatureScope

@FeatureScope
@Component(
    dependencies = [ApplicationComponent::class, ColorUpdateProvider::class, ActivityContextProvider::class],
    modules = [ProducerFragmentModule::class]
)
interface ProducerFragmentComponent {

    fun inject(producerFragment: ProducerFragment)

    companion object {
        fun create(app: App, activity: MainActivity): ProducerFragmentComponent {
            val activityComponent = activity.getActivityComponent()
            return DaggerProducerFragmentComponent.builder()
                .applicationComponent(app.getAppComponent())
                .colorUpdateProvider(activityComponent)
                .activityContextProvider(activityComponent)
                .build()
        }
    }
}