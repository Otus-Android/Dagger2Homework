package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import javax.inject.Singleton

@Singleton
@Component(modules = [BindsColorGenerator::class])
interface ApplicationComponent {
    @ApplicationContext
    fun provideAppContext(): Context

    fun provideColorGenerator(): ColorGenerator



    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ApplicationContext context: Context): ApplicationComponent
    }
}

@Module
interface BindsColorGenerator {
    @Binds
    fun bindsColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}


