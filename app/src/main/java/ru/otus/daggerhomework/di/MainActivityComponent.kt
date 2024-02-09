package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.MyObserver
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface MainActivityComponent {
    @Component.Factory
    interface factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }

    fun inject(act: MainActivity)

    @FragmentScope
    fun provideObserver(): MyObserver

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context
}

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope
