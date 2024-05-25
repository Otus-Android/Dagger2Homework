package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.annotation.Application

@Module
interface AppModule {

    companion object {
        @Application
        @Provides
        @JvmStatic
        fun provideApplicationContext(context: Context): Context {
            return context
        }
    }

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}
