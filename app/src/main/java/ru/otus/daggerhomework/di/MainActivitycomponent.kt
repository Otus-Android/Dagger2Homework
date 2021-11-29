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
import ru.otus.daggerhomework.utils.ViewModelkey
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@Module
interface ViewModule{
    @Singleton
    @Binds
    @[IntoMap ViewModelkey(ViewModelProducer::class)]
    fun viewModelProvider(viewModel: ViewModelProducer): ViewModel
    @Singleton
    @Binds
    @[IntoMap ViewModelkey(ViewModelReceiver::class)]
    fun viewModelReceiver(viewModel: ViewModelReceiver): ViewModel
}

@Module(includes = [ViewModule::class])
class MainActivityModule {
    @Singleton
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }

    @Singleton
    @Provides
    fun provideColor(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}

@Singleton
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

    fun getViewModule():ViewModleFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("MainActivityContext") context: Context,
                   applicationComponent: ApplicationComponent): MainActivityComponent
    }
}
