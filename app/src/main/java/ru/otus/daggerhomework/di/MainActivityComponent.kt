package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.*
import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
annotation class ActivityContext

@Scope
annotation class ActivityScope

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    fun provideReceiverComponent(): FragmentReceiverComponent.Builder

    fun provideProducerComponent(): FragmentProducerComponent.Builder

    @Component.Factory
    interface Factory {
        fun create(
            @[BindsInstance ActivityContext] context: Context,
            component: ApplicationComponent
        ): MainActivityComponent
    }
}

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface MainActivityModule {

    @Binds
    fun bindProducer(eventBus: EventBusImpl): EventBusProducer

    @Binds
    fun bindReceiver(eventBus: EventBusImpl): EventBusReceiver

    @Binds
    fun bindGenerator(eventBus: ColorGeneratorImpl): ColorGenerator
}

