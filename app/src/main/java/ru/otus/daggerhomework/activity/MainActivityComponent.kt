package ru.otus.daggerhomework.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ApplicationComponent
import ru.otus.daggerhomework.feature.providers.ActivityContextProvider
import ru.otus.daggerhomework.feature.providers.ColorUpdateProvider
import ru.otus.daggerhomework.qualifier.ActivityContext
import ru.otus.daggerhomework.feature.providers.ColorProvider
import ru.otus.daggerhomework.scope.ActivityScope

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent : ActivityContextProvider, ColorUpdateProvider, ColorProvider {
    @Component.Factory
    interface ContextFactory {
        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}