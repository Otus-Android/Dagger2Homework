package ru.otus.daggerhomework.di.application

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.annotation.ApplicationContext

@Module
interface AppModule {

    companion object {
        @ApplicationContext
        @Provides
        @JvmStatic
        fun provideApplicationContext(context: Context): Context {
            return context
        }
    }

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}
