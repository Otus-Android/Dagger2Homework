package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.utils.ActivityScope
import ru.otus.daggerhomework.utils.AppScope
import javax.inject.Named


@Module()
class ApplicationModule {
    @AppScope
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun providesStateFlow(): MutableStateFlow<Int>

    @Named("ApplicationContext")
    fun getApplication():Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("ApplicationContext") context: Context): ApplicationComponent
    }
}
