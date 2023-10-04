package ru.otus.daggerhomework

import dagger.Component

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