package ru.otus.daggerhomework.di


import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named

@ActivityScope
@Subcomponent
interface MainActivityComponent {

    fun inject (mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create (@BindsInstance @Named("MainActivityContext") context: Context):MainActivityComponent
    }
    fun fragmentProducerComponent() :FragmentProducerComponent.Factory
    fun fragmentReceiverComponent() :FragmentReceiverComponent.Factory

}
