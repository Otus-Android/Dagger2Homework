package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.module.ActivityModule
import ru.otus.daggerhomework.di.scope.ActivityScope

@ActivityScope
@Component(modules = [ActivityModule::class])
interface MainActivityComponent {

    fun getActivityContext(): Context

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Builder
    fun fragmentProducerComponent(): FragmentProducerComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activityContext(context: Context): Builder

        fun build(): MainActivityComponent
    }
}