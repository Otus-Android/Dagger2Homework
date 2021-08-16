package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
interface ProducerModule {

    @FragmentScope
    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}

@Module
class FragmentsModule {

    @Provides
    @ActivityContext
    fun provideActivityContext(activity: Activity): Context {
        return activity
    }

    @Provides
    @ApplicationContext
    fun provideAppContext(context: Context): Context {
        return context
    }
}