package ru.otus.daggerhomework.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named
import javax.inject.Scope

@MainActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [DataModule::class])
interface MainActivityComponent {


    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @Named("ActivityContext")
            activityContext: Context,
            appComponent: ApplicationComponent,
            dataModule: DataModule,
        ): MainActivityComponent
    }

    @Named("ActivityContext")
    fun provideActivityContext(): Context
    fun provideApplicationContext(): ApplicationComponent

    // Как я понял, данные методы необходимы, чтобы создавались сабкомпоненты, дабы инжектить в них
    // инстансы фрагментов, чтобы дата передавалась через них. Как сделать по-другому у меня нет идей =(
    fun provideProducerComponent(): FragmentProducerComponent.Factory
    fun provideReceiverComponent(): FragmentReceiverComponent.Factory

    fun provideColorFlow(): MutableSharedFlow<Int>
    fun provideStateFlow(): MutableStateFlow<State>
}

@Scope
annotation class MainActivityScope

@Module
@Named("DataModule")
class DataModule {
    private val colorFlow = MutableSharedFlow<Int>(replay = 1)

    private val stateFlow = MutableStateFlow<State>(Empty)

    @Provides
    fun provideColorFlow(): MutableSharedFlow<Int> = colorFlow

    @Provides
    fun provideStateFlow(): MutableStateFlow<State> = stateFlow
}

sealed interface State
data class Success(val message: String) : State
object Empty : State