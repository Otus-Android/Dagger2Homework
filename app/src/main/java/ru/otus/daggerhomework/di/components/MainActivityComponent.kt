package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.annotations.AppContext
import ru.otus.daggerhomework.di.annotations.MainActivityScope
import ru.otus.daggerhomework.di.annotations.StateFlowColor
import ru.otus.daggerhomework.di.modules.ActivityModule
import ru.otus.daggerhomework.utils.ColorGenerator

@MainActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface MainActivityComponent {
    fun provideColorGenerator(): ColorGenerator


    @StateFlowColor
    fun provideStateFlow(): StateFlow<Int>

    @StateFlowColor
    fun provideMutableStateFlow(): MutableStateFlow<Int>


    @AppContext
    fun provideApplicationContext(): Context

    fun provideActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance context: Context
        ): MainActivityComponent
    }
}