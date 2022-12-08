package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.*

@Subcomponent(modules = [MainModule::class, ActivitySubcomponents::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            @BindsInstance color: MutableLiveData<Int>
        ): MainActivityComponent
    }
    fun producerComponent(): FragmentProducerComponent.Factory
    fun receiverComponent(): FragmentReceiverComponent.Factory
}
@Module
interface MainModule
{
    @Binds
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl):ColorGenerator
    @Binds
    fun provideLiveData(color: MutableLiveData<Int>):LiveData<Int>
}