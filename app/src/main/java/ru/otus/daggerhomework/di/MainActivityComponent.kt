package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.viewModel.ColorObserver
import ru.otus.daggerhomework.viewModel.ColorObserverImpl
import javax.inject.Qualifier

@ActivityScope
@Subcomponent(
    modules = [
        MainActivitySubcomponentsModule::class,
        MainActivityModule::class
    ]
)
interface MainActivityComponent {

    fun addProducerFragmentSubComponent(): FragmentProducerComponent.Factory

    fun addReceiverFragmentSubComponent(): FragmentReceiverComponent.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext activity: Context): MainActivityComponent
    }

}

@Module(
    subcomponents = [
        FragmentProducerComponent::class,
        FragmentReceiverComponent::class
    ]
)
object MainActivitySubcomponentsModule

@Module
interface MainActivityModule {

    @ActivityScope
    @Binds
    fun bindColorObserver(customObserverImpl: ColorObserverImpl): ColorObserver
}

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext