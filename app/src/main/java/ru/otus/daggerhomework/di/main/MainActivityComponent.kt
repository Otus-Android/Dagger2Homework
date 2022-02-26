package ru.otus.daggerhomework.di.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.ApplicationContext

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @ActivityContext context: Context,
            component: ApplicationComponent,
            @BindsInstance mutableStateFlow: MutableStateFlow<Int>
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorGenerate(): ColorGenerator

    fun provideObserver(): MutableStateFlow<Int>
}