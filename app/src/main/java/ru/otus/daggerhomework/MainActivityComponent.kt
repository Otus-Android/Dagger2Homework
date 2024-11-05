package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier


@Component(
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

}

@Qualifier
annotation class ActivityContext