package ru.otus.daggerhomework.di

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.utils.ActivityScope
import ru.otus.daggerhomework.utils.ApplicationContext

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [MainMutableStateModule::class, MainStateModule::class]
)
interface MainActivityComponent {

    fun providesMutableStateFlow(): MutableStateFlow<Int>

    fun providesStateFlow(): StateFlow<Int>

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
class MainMutableStateModule {

    @ActivityScope
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}

@Module
interface MainStateModule {

    @ActivityScope
    @Binds
    fun bindsStateFlow(
        mutableStateFlow: MutableStateFlow<Int>
    ): StateFlow<Int>
}
