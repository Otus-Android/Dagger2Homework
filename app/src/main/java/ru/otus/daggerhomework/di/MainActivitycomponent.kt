package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.*
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.*
import ru.otus.daggerhomework.utils.ActivityScope
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@Module()
class MainActivityModule {
    @ActivityScope
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun providesStateFlow(): MutableStateFlow<Int>

    @Named("ApplicationContext")
    fun providesAppContext(): Context

    @Named("MainActivityContext")
    fun providesActivityContext(): Context


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("MainActivityContext") context: Context,
                   applicationComponent: ApplicationComponent): MainActivityComponent
    }
}
