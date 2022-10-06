package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    @ActivityQualifier
    fun activityContext(): Context

    @AppQualifier
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityQualifier context: Context, applicationComponent: ApplicationComponent
        ): ActivityComponent
    }


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