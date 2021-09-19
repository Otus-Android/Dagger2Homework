package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.module.ActivityModule

@Component(modules = [ActivityModule::class])
interface MainActivityComponent {

    fun getActivityContext(): Context

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Builder
    fun fragmentProducerComponent(): FragmentProducerComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): MainActivityComponent
    }
}