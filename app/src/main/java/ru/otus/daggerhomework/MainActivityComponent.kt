package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow

@Component(modules = [ColorGeneratorModule::class])
interface MainActivityComponent {

    fun provideContext(): Context

    fun provideFlow(): MutableStateFlow<Int>

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
object ColorGeneratorModule {

    @Provides
    fun provide(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator {
        return colorGeneratorImpl
    }
}