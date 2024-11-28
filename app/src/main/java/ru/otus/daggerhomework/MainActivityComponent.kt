package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Component(modules = [ColorGeneratorModule::class, StateFlowModule::class])
interface MainActivityComponent {

    fun provideContext(): Context

    fun provideFlow(): StateFlow<Int>

    fun provideMutableFlow(): MutableStateFlow<Int>

    fun provideColorGenerator(): ColorGenerator

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
            @BindsInstance flow: MutableStateFlow<Int>
        ): MainActivityComponent
    }
}

@Module
interface ColorGeneratorModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@Module
interface StateFlowModule {

    @Binds
    fun bindStateFlow(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int>
}