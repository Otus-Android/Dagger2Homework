package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.qualifiers.ActivityContext
import ru.otus.daggerhomework.qualifiers.AppContext
import ru.otus.daggerhomework.scopes.ActivityScope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class],
)
interface MainActivityComponent {

    @AppContext
    fun provideApplicationContext() : Context

    @ActivityContext
    fun provideActivityContext() : Context

    fun provideColorEventSource(): ColorEventSource

    fun inject(activity : MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @ActivityContext
            activityContext : Context,
            appComponent : ApplicationComponent,
        ) : MainActivityComponent
    }
}
