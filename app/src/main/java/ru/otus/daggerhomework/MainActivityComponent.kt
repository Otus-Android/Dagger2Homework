package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(modules = [ColorStateModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityName context: Context): MainActivityComponent
    }
}

@Module
object ColorStateModule {

    @Provides
    @ActivityScope
    fun provideColorSharedFlow() = MutableSharedFlow<Int>()
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityName