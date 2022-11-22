package ru.otus.daggerhomework.main

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.*
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainModule::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent,
        ): MainActivityComponent
    }
}
