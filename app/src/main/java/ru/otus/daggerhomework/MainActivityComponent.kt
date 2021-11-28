package ru.otus.daggerhomework

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.qualifiers.ActivityScope

@ActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    fun activityContext(): Context

    val observerFlow: MutableStateFlow<Int>
}

@Module
class MainActivityModule {
    @Provides
    @ActivityScope
    fun provideColorEvent(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }

}