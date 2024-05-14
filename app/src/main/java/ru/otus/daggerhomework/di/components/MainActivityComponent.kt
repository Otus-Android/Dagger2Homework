package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.qualifiers.ActivityContext
import ru.otus.daggerhomework.di.qualifiers.AppContext

@Component(
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {
    @AppContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }
}