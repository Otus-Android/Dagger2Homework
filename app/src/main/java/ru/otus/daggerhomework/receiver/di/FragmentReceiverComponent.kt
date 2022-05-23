package ru.otus.daggerhomework.receiver.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.common.FragmentScope
import ru.otus.daggerhomework.common.NeedInitializeException
import ru.otus.daggerhomework.common.ViewModelProviderFactory
import ru.otus.daggerhomework.main.api.MainActivityApi
import javax.inject.Named

@Component(
    modules = [ReceiverViewModuleBindings::class],
    dependencies = [ReceiverDependency::class]
)
@FragmentScope
interface FragmentReceiverComponent {

    val viewModelProviderFactory: ViewModelProviderFactory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named(APPLICATION_CONTEXT_QUALIFIER) applicationContext: Context,
            @BindsInstance @Named(ACTIVITY_CONTEXT_QUALIFIER) context: Context,
            dependency: ReceiverDependency
        ): FragmentReceiverComponent
    }

    companion object {
        const val APPLICATION_CONTEXT_QUALIFIER = "applicationContext"
        const val ACTIVITY_CONTEXT_QUALIFIER = "activityContext"

        private var mComponent: FragmentReceiverComponent? = null
        private var mMainActivityApiProvider: () -> MainActivityApi =
            { throw NeedInitializeException() }

        fun init(mainActivityApiProvider: () -> MainActivityApi) {
            mMainActivityApiProvider = mainActivityApiProvider
        }

        fun getInstance() = mComponent ?: DaggerFragmentReceiverComponent.factory().create(
            applicationContext = mMainActivityApiProvider().provideApplicationContext(),
            context = mMainActivityApiProvider().provideActivityContext(),
            dependency = object : ReceiverDependency {
                override fun provideEventObservable() = mMainActivityApiProvider().eventObservable
            }
        ).apply { mComponent = this }

        fun release() {
            mComponent = null
        }
    }

}