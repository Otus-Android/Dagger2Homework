package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

@Module
object MainActivityModule {

    @ActivityScope
    @Provides
    fun provideColorObserver(): MutableLiveData<Int> {
        return MutableLiveData<Int>()
    }
}

@ActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }

    @ActivityContext
    fun activityContext(): Context

    fun colorObserver(): MutableLiveData<Int>
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityContext