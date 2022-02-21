package ru.otus.daggerhomework
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.ref.WeakReference
import javax.inject.Qualifier

@Component
interface MainActivityComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Activity activityContext: WeakReference<Context>, @BindsInstance stateFlow: MutableStateFlow<Int>): MainActivityComponent
    }
    @Activity fun provideContext(): WeakReference<Context>
    fun provideMutableStateFlow(): MutableStateFlow<Int>
}

@Qualifier
annotation class Activity