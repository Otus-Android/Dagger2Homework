package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.di.module.ActivityModule
import ru.otus.daggerhomework.di.scope.ActivityScope

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface MainActivityComponent {

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Builder
    fun fragmentProducerComponent(): FragmentProducerComponent.Builder

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activityContext(context: Context): Builder

        fun build(): MainActivityComponent
    }
}