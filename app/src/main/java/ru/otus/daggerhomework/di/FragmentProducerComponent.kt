package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.scope.FeatureScope

@FeatureScope
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [ApplicationComponent::class, MainActivityComponent::class]
)
interface FragmentProducerComponent {

    companion object {
        fun create(app: App, mainActivity: MainActivity): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.builder()
                .applicationComponent(app.appComponent)
                .mainActivityComponent(mainActivity.activityComponent)
                .build()
        }
    }

    fun inject(fragmentProducer: FragmentProducer)
}