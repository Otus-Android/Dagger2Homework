package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named

@ActivityScope
@Subcomponent(
    modules = [ViewModelsModule::class, MainActivitySubcomponentsModule::class]
)
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @Named("ActivityContext")
            activityContext: Context
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface MainActivitySubcomponentsModule
