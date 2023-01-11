package ru.otus.daggerhomework.di

import android.content.Context
import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.*
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@ColorScope
@Subcomponent(modules = [MainModule::class, ActivitySubcomponents::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context
        ): MainActivityComponent
    }
    fun producerComponent(): FragmentProducerComponent.Factory
    fun receiverComponent(): FragmentReceiverComponent.Factory
}

@Module
interface MainModule {
    companion object {
        @Provides
        @ColorScope
        fun provideColor(): MutableLiveData<Int> {
            return MutableLiveData(Color.argb(0, 0, 0, 0))
        }
    }
    @Binds
    fun bindColor(color:MutableLiveData<Int>):LiveData<Int>
    @Binds
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

}