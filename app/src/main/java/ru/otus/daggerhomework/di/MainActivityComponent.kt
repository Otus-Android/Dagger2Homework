package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.BindsMainModule
import ru.otus.daggerhomework.StateFlowDependency
import javax.inject.Singleton

@Singleton
@Component(modules = [BindsMainModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent : StateFlowDependency {

    @Component.Factory
    interface Factory {
        fun getComponent(
            @BindsInstance @ActivityContext context: Context,
            applicationComponent: ApplicationComponent
        ): StateFlowDependency
    }
}
