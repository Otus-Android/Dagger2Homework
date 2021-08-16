package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

@MainScope
@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    val activity: Activity

    val context: Context

    val observerFlow: MutableStateFlow<Int>

    @Component.Builder
    interface Builder {

        fun appComponent(applicationComponent: ApplicationComponent): Builder

        @BindsInstance
        fun context(activity: Activity): Builder

        fun build(): MainActivityComponent
    }
}