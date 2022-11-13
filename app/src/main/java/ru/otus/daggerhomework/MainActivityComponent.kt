package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class],
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            context: Context,
            appComponent: ApplicationComponent,
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideStateFlow(): MutableStateFlow<Int?>
}

@Module
object MainActivityModule {

    @ActivityScope
    @Provides
    fun provideObserver(): MutableStateFlow<Int?> = MutableStateFlow(null)
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityContext