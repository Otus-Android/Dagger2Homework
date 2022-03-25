package ru.otus.daggerhomework.di.components

import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
                   @BindsInstance stateFlow: StateFlow<Int>,
                   @BindsInstance context: FragmentActivity
        ): ActivityComponent
    }

    fun provideContext(): FragmentActivity

    @ApplicationContext
    fun provideAppContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideObserver(): StateFlow<Int>


}
@Scope
annotation class ActivityScope