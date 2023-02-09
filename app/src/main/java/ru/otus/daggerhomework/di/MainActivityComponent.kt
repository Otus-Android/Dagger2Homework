package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ProducerObserver::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance @Named("activityContext") context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    fun fragmentProducerComponent(): FragmentProducerComponent

    fun fragmentReceiverComponent(): FragmentReceiverComponent


}

@Module
object ProducerObserver{

    @Singleton
    @Provides
    fun provideBase(): MutableLiveData<Int> {
        return MutableLiveData<Int>()
    }

    @Provides
    fun provideProducer(
        provideBase: MutableLiveData<Int>
    ): MutableLiveData<Int> {
        return provideBase
    }

    @Provides
    fun provideObserver(
        provideBase: MutableLiveData<Int>
    ): LiveData<Int> {
        // val observer: LiveData<Int> = producer
        return provideBase
    }

}

@Scope
annotation class ActivityScope