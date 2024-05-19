package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.annotation.Application

@Module
object AppModule {
    @Application
    @Provides
    @JvmStatic
    fun provideApplicationContext(context: Context): Context {
        return context
    }

    @Provides
    @JvmStatic
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}
