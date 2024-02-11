package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorGenerator(): ColorGenerator
}

@Module
interface AppModule {
    @Binds
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}