package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named
import javax.inject.Singleton

//@Component(modules = [DataModule::class])
@Component
@Singleton
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @Named("ApplicationContext")
            appContext: Context
            //dataModule: DataModule,
        ): ApplicationComponent
    }

    @Named("ApplicationContext")
    fun provideContext(): Context
    /*fun provideColorFlow(): MutableSharedFlow<Int>
    fun provideStateFlow(): MutableStateFlow<State>*/
}


/*@Module
@Named("DataModule")
class DataModule {
    private val colorFlow = MutableSharedFlow<Int>(replay = 1)

    private val stateFlow = MutableStateFlow<State>(Empty)

    @Provides
    @Singleton
    fun provideColorFlow(): MutableSharedFlow<Int> = colorFlow

    @Provides
    @Singleton
    fun provideStateFlow(): MutableStateFlow<State> = stateFlow
}*/
