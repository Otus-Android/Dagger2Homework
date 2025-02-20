package ru.otus.daggerhomework.di.component

import android.app.Activity
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.di.scope.ActivityScope
import ru.otus.daggerhomework.di.module.MainActivityModule

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)

interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun build(
            appComponent: ApplicationComponent,
            @BindsInstance activity: Activity
        ): MainActivityComponent
    }

    fun provideColorState(): ColorState

}