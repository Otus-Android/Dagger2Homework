package ru.otus.daggerhomework.di

import android.app.Activity
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorsController
import ru.otus.daggerhomework.ColorsControllerProvider
import javax.inject.Scope

@Scope
annotation class ActivityScope

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
)
interface ActivityComponent : AppProvider, ColorsControllerProvider {
    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance activity: Activity,
            @BindsInstance colorsController: ColorsController,
        ): ActivityComponent
    }

    fun provideActivity(): Activity
}

interface ActivityComponentProvider {
    fun provideActivityComponent(): ActivityComponent
}

