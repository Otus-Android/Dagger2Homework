package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow

@ActivityScope
@Component(dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun crete(
            @ActivityContext @BindsInstance context: Context,
            applicationComponent: ApplicationComponent,
        ): MainActivityComponent
    }


    fun inject(activity: MainActivity)

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideState(): MutableStateFlow<Int>
}
