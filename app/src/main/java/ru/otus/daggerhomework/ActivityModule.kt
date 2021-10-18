package ru.otus.daggerhomework

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    fun provideEvent(): MutableLiveData<Int> {
        return MutableLiveData()
    }
}