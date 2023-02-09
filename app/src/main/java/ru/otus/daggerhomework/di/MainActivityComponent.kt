package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ProducerObserver::class, FragmentModules::class, ColorsGeneratorModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance @Named("activityContext") context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    fun fragmentProducerComponent(): FragmentProducerComponent.Builder

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Builder


}

@Module
object ProducerObserver{

    @ActivityScope
    @Provides
    fun provideProducer(): MutableLiveData<Int> {
        return MutableLiveData<Int>()
    }
/*
    @Provides
    fun provideProducer(
        provideBase: MutableLiveData<Int>
    ): MutableLiveData<Int> {
        return provideBase
    }*/

    @Provides
    fun provideObserver(
        provideBase: MutableLiveData<Int>
    ): LiveData<Int> {
        // val observer: LiveData<Int> = producer
        return provideBase
    }

}

@Module
object ColorsGeneratorModule {

    @ActivityScope
    @Provides
    fun provideGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
/*
    @Binds
    abstract fun bindGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator/* {
        return colorGenerator
    }*/*/

}

@Module(subcomponents = [FragmentProducerComponent::class])
class FragmentModules

@Scope
annotation class ActivityScope