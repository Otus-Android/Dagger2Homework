package ru.otus.daggerhomework.main.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.MutableEventObservable
import ru.otus.daggerhomework.producer.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.producer.di.FragmentProducerComponent
import ru.otus.daggerhomework.producer.di.ProducerDependency
import javax.inject.Named

@Module
class MainActivityModule {

    //@Provides
    //@Named("1")
//    @Named(MainActivityComponent.ACTIVITY_CONTEXT_QUALIFIER)
//    fun provideActivityContext(
//        @Named(MainActivityComponent.ACTIVITY_CONTEXT_QUALIFIER) activityContext: Context
//    ): Context = activityContext
//
//    @Provides
//    //@Named("2")
//    @Named(MainActivityComponent.APPLICATION_CONTEXT_QUALIFIER)
//    fun provideApplicationContext(
//        @Named(MainActivityComponent.APPLICATION_CONTEXT_QUALIFIER) applicationContext: Context
//    ): Context = applicationContext

//    @Provides
//    fun provideFragmentProducerComponent(
//        @Named(MainActivityComponent.APPLICATION_CONTEXT_QUALIFIER) applicationContext: Context,
//        @Named(MainActivityComponent.ACTIVITY_CONTEXT_QUALIFIER) context: Context,
//        eventObservable: MutableEventObservable
//    ): FragmentProducerComponent = DaggerFragmentProducerComponent.factory().create(
//        applicationContext = applicationContext,
//        context = context,
//        dependency = object : ProducerDependency {
//            override fun provideEventObservable() = eventObservable
//        }
//    )

}