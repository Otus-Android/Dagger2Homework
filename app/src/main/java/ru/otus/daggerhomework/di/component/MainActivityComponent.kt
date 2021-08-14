package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.module.MainActivityModule
import ru.otus.daggerhomework.di.scope.ActivityScope

@ActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent, @BindsInstance context: Context): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun provideSharedFlow() : SharedFlow<Int>

    fun provideColorGenerator() : ColorGenerator
}