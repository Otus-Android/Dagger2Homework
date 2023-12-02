package ru.otus.daggerhomework.di.fragments

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.activity.ActivityComponent

@FragmentScope
@Component(
    modules = [ViewModelModule::class],
    dependencies = [ActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Component.Factory
    interface FragmentReceiverComponentFactory {
        fun create(activityComponent: ActivityComponent): FragmentReceiverComponent
    }

    companion object {
        private var fragmentReceiverComponent: FragmentReceiverComponent? = null

        fun getFragComponent(activityComponent: ActivityComponent): FragmentReceiverComponent {
            return fragmentReceiverComponent ?: DaggerFragmentReceiverComponent
                .factory().create(activityComponent).also {
                    fragmentReceiverComponent = it
                }
        }
    }
}