package ru.otus.daggerhomework.applicaion

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Named
import javax.inject.Singleton

@Component(modules = [FlowModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance
            @Named("ApplicationContext")
            context: Context,
            flowModule: FlowModule
        ): ApplicationComponent
    }

    @Named("ApplicationContext")
    fun getApplicationContext(): Context
    fun getFlow(): Flow<Int>
    fun getMutableFlow(): MutableSharedFlow<Int>

}

@Module
class FlowModule {

    private val colorsFlow = MutableSharedFlow<Int>(replay = 1)

    @Provides
    @Singleton
    fun provideFlow(): Flow<Int> = colorsFlow

    @Provides
    @Singleton
    fun provideMutableFlow(): MutableSharedFlow<Int> = colorsFlow

}
