package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance  @ApplicationContext context: Context
        ): ApplicationComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideState(): MutableStateFlow<Int>
}

@Module
interface ApplicationModule {

    companion object {
        @Provides
        @Singleton
        fun provideState() = MutableStateFlow(0)
    }

    @Binds
    @Singleton
    fun bindColorGenerator(generator: ColorGeneratorImpl): ColorGenerator
}