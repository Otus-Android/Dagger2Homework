package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ActivityComponent
    }

    fun activityContext(): Context

    val observerFlow: MutableStateFlow<Int>
}

@Module
class ActivityModule {
    @Provides
    @ActivityScope
    fun provideColorEvent(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}