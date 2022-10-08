package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ActivityContext
import ru.otus.daggerhomework.ApplicationContext
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.modules.MainActivityModule
import ru.otus.daggerhomework.scopes.ActivityScope

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @ActivityContext fun provideContext(): Context
    @ApplicationContext fun provideApplicationContext(): Context

    fun provideColor() : MutableStateFlow<Int>

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun add(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }
}