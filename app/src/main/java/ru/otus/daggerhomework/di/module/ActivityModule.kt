package ru.otus.daggerhomework.di.module

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.scope.ActivityScope

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    fun provideEvent(): MutableLiveData<Int> {
        return MutableLiveData()
    }

}