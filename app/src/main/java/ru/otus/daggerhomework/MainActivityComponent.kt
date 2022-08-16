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
@Component(modules = [ColorStateModule::class])
interface MainActivityComponent {

    fun provideColorSharedFlow(): MutableStateFlow<Int>
    fun provideColorGenerator(): ColorGenerator
    @ActivityName
    fun provideContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityName context: Context): MainActivityComponent
    }
}

@Module
object ColorStateModule {

    @Provides
    @ActivityScope
    fun provideColorSharedFlow() = MutableStateFlow<Int>(0)

    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityName