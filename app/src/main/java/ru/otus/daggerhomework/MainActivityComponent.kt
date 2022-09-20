package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(modules = [ColorStateModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun provideColorStateFlow(): StateFlow<Int>
    fun provideColorMutableStateFlow(): MutableStateFlow<Int>
    fun provideColorGenerator(): ColorGenerator
    @ActivityName
    fun provideContext(): Context

    @AppName
    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityName context: Context, applicationComponent: ApplicationComponent): MainActivityComponent
    }
}

@Module
interface ColorStateModule {

    companion object {
        @Provides
        @ActivityScope
        fun provideColorMutableStateFlow() = MutableStateFlow(0)


        @Provides
        @ActivityScope
        fun provideColorStateFlow(mutable: MutableStateFlow<Int>) = mutable.asStateFlow()
    }

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityName