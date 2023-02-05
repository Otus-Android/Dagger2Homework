package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.otus.daggerhomework.utils.ColorConsumer
import ru.otus.daggerhomework.utils.ColorObserver
import ru.otus.daggerhomework.utils.ColorProducer
import javax.inject.Qualifier

@Qualifier
annotation class ActivityContext

@ActivityScope
@Subcomponent(
    modules = [
        MainActivitySubComponentsModule::class,
        MainActivityUtilsModule::class
    ]
)

interface MainActivityComponent {

    fun fragmentProducerComponent(): FragmentProducerComponent.Factory

    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory

    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance @ActivityContext context: Context): MainActivityComponent
    }
}

@Module(
    subcomponents = [
        FragmentProducerComponent::class,
        FragmentReceiverComponent::class
    ]
)
interface MainActivitySubComponentsModule

@Module
object MainActivityUtilsModule {

    @ActivityScope
    @Provides
    fun provideColorObserver() = ColorObserver()

    @ActivityScope
    @Provides
    fun provideColorConsumer(observer: ColorObserver): ColorConsumer = observer

    @ActivityScope
    @Provides
    fun provideColorProducer(observer: ColorObserver): ColorProducer = observer
}
