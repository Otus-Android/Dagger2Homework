package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope


@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {

    fun provideApplicationContext(): Context
    fun provideObserver(): CustomObserver
    fun provideProducer(): CustomProducer

    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): MainActivityComponent
    }

}

@Module
interface MainActivityModule {
    @Binds
    fun provideReceiver(customProducer: CustomProducer): CustomObserver

}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope
