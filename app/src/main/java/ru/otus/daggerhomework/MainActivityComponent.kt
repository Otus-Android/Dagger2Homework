package ru.otus.daggerhomework
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.StateFlow

@Component
interface MainActivityComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activityContext: Context, @BindsInstance stateFlow: StateFlow<String>): MainActivityComponent
    }
}