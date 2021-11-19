package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.utils.ActivityScope
import ru.otus.daggerhomework.utils.ApplicationContext

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun providesStateFlow(): MutableStateFlow<Int>

    @ApplicationContext
    fun providesAppContext(): Context

    fun providesActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            appComponent: AppComponent
        ): MainActivityComponent
    }
}

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }

}