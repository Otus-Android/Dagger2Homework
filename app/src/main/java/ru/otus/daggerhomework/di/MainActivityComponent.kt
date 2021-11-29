package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.Transceiver

@ActivityScope
@Component(
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun provideActivityContext(): Context
    fun provideColorGenerator(): ColorGenerator
    fun provideTransceiver(): Transceiver

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }
}

@Module
interface MainActivityModule {
    @ActivityScope
    @Binds
    fun colorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    companion object {
        @ActivityScope
        @Provides
        fun provideTransceiver(): Transceiver {
            return Transceiver()
        }
    }
}