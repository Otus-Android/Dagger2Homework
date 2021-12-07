package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface MainActivityComponent {

    @get:ActivityContext
    val context: Context

    @get:ApplicationContext
    val applicationContext: Context

    val mutableStateFlow: MutableStateFlow<Int>

    val stateFlow: StateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @ActivityContext
            @BindsInstance
            context: Context,
            applicationComponent: ApplicationComponent,
        ): MainActivityComponent
    }
}