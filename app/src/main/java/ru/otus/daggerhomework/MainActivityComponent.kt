package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow

@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideObserver(): MutableStateFlow<Int?>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            @BindsInstance stateFlow: MutableStateFlow<Int?> = MutableStateFlow(null),
            appComponent: ApplicationComponent = (context.applicationContext as App).applicationComponent,
            ): MainActivityComponent
    }
}