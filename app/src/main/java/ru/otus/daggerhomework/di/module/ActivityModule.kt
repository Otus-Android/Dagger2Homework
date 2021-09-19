package ru.otus.daggerhomework.di.module

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.di.component.FragmentReceiverComponent
import ru.otus.daggerhomework.di.scope.ActivityScope

@Module(subcomponents = [FragmentReceiverComponent::class, FragmentReceiverComponent::class])
class ActivityModule {

    @Provides
    @ActivityScope
    fun provideEvent(): MutableLiveData<Int> {
        return MutableLiveData()
    }

    @Provides
    @ActivityScope
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}