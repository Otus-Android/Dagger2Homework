package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

const val NAME_ACTIVITY_CONTEXT = "activityContext"

@ActivityScope
@Component(
    dependencies = [MainActivityDependencies::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent : FragmentProducerDependencies, FragmentReceiverDependencies {
    
    @Component.Factory
    interface Factory {
        fun create(
            mainActivityDependencies: MainActivityDependencies,
            @Named(NAME_ACTIVITY_CONTEXT)
            @BindsInstance context: Context,
        ): MainActivityComponent
    }
    
}