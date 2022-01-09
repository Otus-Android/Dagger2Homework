package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.modules.viewModels.ViewModelFactory
import ru.otus.daggerhomework.views.MainActivity
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {
    @ActivityScope
    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent,
                   @BindsInstance mutableStateFlow: MutableStateFlow<Int>,
                   @FragmentActivityContext
                   @BindsInstance context: Context

        ): ActivityComponent
    }

    @FragmentActivityContext
    fun provideContext(): Context

    fun provideObserver(): MutableStateFlow<Int>


}
@Scope
annotation class ActivityScope
@Qualifier
annotation class FragmentActivityContext