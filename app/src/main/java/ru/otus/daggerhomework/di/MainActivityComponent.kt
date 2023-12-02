package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Qualifier
import javax.inject.Scope

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)

    @AppContext
    fun appContext(): Context

    fun provideViewModelProducer(): ViewModelProducer

    fun provideViewModelReceiver(): ViewModelReceiver

    @ActivityContext
    fun activityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance
            @ActivityContext
            context: Context
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

    companion object{
        @Provides
        @MainActivityScope
        fun provideStateFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(544)
        }
    }

    @Binds
    fun provideColorState(colorState: MutableStateFlow<Int>): StateFlow<Int>

    @Binds
    fun provideColorGeneratorImpl(colorGeneratorImpl: ColorGeneratorImpl) : ColorGenerator
}

@Scope
annotation class MainActivityScope

@Qualifier
annotation class ActivityContext

