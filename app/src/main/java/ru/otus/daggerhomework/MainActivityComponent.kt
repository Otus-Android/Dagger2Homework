package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
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

    @MainActivityContext
    fun activityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @MainActivityContext context: Context
        ): MainActivityComponent
    }
}

@Module
interface MainActivityModule {

      companion object{
         @Provides
         @MainActivityScope
         fun provideStateFlow(): MutableStateFlow<Int>{
             return MutableStateFlow(544)
         }
     }

    @Binds
    fun provideColorGeneratorImpl(colorGeneratorImpl: ColorGeneratorImpl) :ColorGenerator
}

@Qualifier
annotation class MainActivityContext

@Scope
annotation class MainActivityScope
