package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.modules.CacheModule
import ru.otus.daggerhomework.modules.ColorGeneratorModule
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityScope
import ru.otus.daggerhomework.scopes_and_qualifiers.AppContext

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [CacheModule::class, ColorGeneratorModule::class])
interface MainActivityComponent {

    @ActivityContext
    fun provideActivityContext(): Context

    @AppContext
    fun provideApplicationContext(): Context

    fun provideCache(): MutableStateFlow<Int>

    fun bindColorGenerator(): ColorGenerator

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance
            @ActivityContext
            context: Context): MainActivityComponent
    }
}