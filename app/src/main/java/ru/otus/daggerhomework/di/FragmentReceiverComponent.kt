package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.scope.FeatureScope

@FeatureScope
@Component(
    modules = [FragmentReceiverModule::class],
    dependencies = [ApplicationComponent::class, MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    companion object {
        fun create(app: App, mainActivity: MainActivity): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .applicationComponent(app.appComponent)
                .mainActivityComponent(mainActivity.activityComponent)
                .build()
        }
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}