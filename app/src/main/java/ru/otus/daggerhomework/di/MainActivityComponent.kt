package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.qualifier.ActivityContext
import ru.otus.daggerhomework.di.scope.ActivityScope

@ActivityScope
@Component(
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext activityContext: Context
        ): MainActivityComponent
    }

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideMutableColorStateFlow(): MutableStateFlow<Int?>

    fun provideColorStateFlow(): StateFlow<Int?>
}